package com.example.ecom_app.basic_ecom.domain.ports.output;

import com.example.ecom_app.basic_ecom.domain.dto.User;

public interface TokenGeneratorPort {
    String generateToken(User user);
    String extractUsername(String token);
    boolean validateToken(String token, User user);
}
