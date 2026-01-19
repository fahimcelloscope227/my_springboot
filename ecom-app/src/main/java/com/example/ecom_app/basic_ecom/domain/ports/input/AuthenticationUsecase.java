package com.example.ecom_app.basic_ecom.domain.ports.input;

import com.example.ecom_app.basic_ecom.domain.dto.LoginResult;

public interface AuthenticationUsecase {

    public LoginResult authenticate(String email, String password);

}
