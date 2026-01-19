package com.example.ecom_app.basic_ecom.adapter.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ecom_app.basic_ecom.adapter.input.dto.ApiResponse;
import com.example.ecom_app.basic_ecom.adapter.input.dto.AuthResponse;
import com.example.ecom_app.basic_ecom.adapter.input.dto.LoginRequest;
import com.example.ecom_app.basic_ecom.adapter.input.dto.RegisterRequest;
import com.example.ecom_app.basic_ecom.domain.dto.User;
import com.example.ecom_app.basic_ecom.domain.ports.input.AuthenticationUsecase;
import com.example.ecom_app.basic_ecom.domain.ports.input.RegisterUserUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

  private final AuthenticationUsecase authenticationUsecase;
  private final RegisterUserUsecase registrationUsecase;
  private static final Logger log = LoggerFactory.getLogger(AuthController.class);

  public AuthController(AuthenticationUsecase authenticationUsecase, RegisterUserUsecase registrationUsecase) {
    this.authenticationUsecase = authenticationUsecase;
    this.registrationUsecase = registrationUsecase;
  }

  @PostMapping("/login")
  public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
    log.info("Login attempt for email: {}", loginRequest.getEmail());
    String token = authenticationUsecase.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

    log.info("token ===> {}", token != null ? "generated" : "not generated");
    AuthResponse authResponse = AuthResponse.builder()
        .token(token)
        .type("Bearer")
        .build();

    return ResponseEntity.ok(ApiResponse.builder()
        .success(true)
        .message("Login successful")
        .data(authResponse)
        .build());

  }

  @PostMapping("/register")
  public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest request) {
    log.info("Register attempt for email: {}", request.getEmail());

    User user = registrationUsecase.register(
        request.getName(),
        request.getEmail(),
        request.getPassword(),
        request.getPhoneNumber());

    log.info("User registered successfully with email: {}", user.getEmail());

    return ResponseEntity.ok(ApiResponse.builder()
        .success(true)
        .message("User registered successfully")
        .data(user)
        .build());
  }

}
