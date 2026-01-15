package com.example.ecom_app.basic_ecom.adapter.input.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_app.basic_ecom.domain.ports.input.AuthenticationUsecase;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticationUsecase authenticationUsecase;
    private final RegisterUserUseCase registrationUsecase;

    public AuthController(AuthenticationUsecase authenticationUsecase, RegisterUserUseCase registrationUsecase) {
        this.authenticationUsecase = authenticationUsecase;
        this.registrationUsecase = registrationUsecase;
    }

}
