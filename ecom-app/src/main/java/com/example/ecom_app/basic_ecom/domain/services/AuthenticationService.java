package com.example.ecom_app.basic_ecom.domain.services;

import com.example.ecom_app.basic_ecom.domain.dto.LoginResult;
import com.example.ecom_app.basic_ecom.domain.dto.User;
import com.example.ecom_app.basic_ecom.domain.ports.input.AuthenticationUsecase;
import com.example.ecom_app.basic_ecom.domain.ports.input.RegisterUserUsecase;
import com.example.ecom_app.basic_ecom.domain.ports.output.PasswordEncoderPort;
import com.example.ecom_app.basic_ecom.domain.ports.output.TokenGeneratorPort;
import com.example.ecom_app.basic_ecom.domain.ports.output.UserRepositoryPort;
import com.example.ecom_app.basic_ecom.domain.exceptions.InvalidCredentialsException;
import com.example.ecom_app.basic_ecom.domain.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService implements AuthenticationUsecase, RegisterUserUsecase {
    private final UserRepositoryPort userRepository;
    private final PasswordEncoderPort passwordEncoder;
    private final TokenGeneratorPort tokenGenerator;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    public AuthenticationService(UserRepositoryPort userRepository, PasswordEncoderPort passwordEncoder,
            TokenGeneratorPort tokenGenerator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public LoginResult authenticate(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("No User Found"));

        if (!user.isActive()) {
            throw new InvalidCredentialsException("User is not active");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Password Not matched");
        }

        String token = tokenGenerator.generateToken(user);

        return LoginResult.builder()
                .token(token)
                .user(user)
                .build();
    }

    @Override
    public User register(String name, String email, String password, String phoneNumber) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("User with email " + email + " already exists");
        }

        log.info("Registering user with email from AuthService: {}", email);

        User user = User.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

}
