package com.example.ecom_app.basic_ecom.domain.ports.input;

import com.example.ecom_app.basic_ecom.domain.dto.User;


public interface RegisterUserUsecase {

    User register(String name, String email, String password, String phoneNumber);

}