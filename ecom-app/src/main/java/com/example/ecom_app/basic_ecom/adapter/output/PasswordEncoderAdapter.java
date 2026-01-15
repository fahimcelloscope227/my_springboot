package com.example.ecom_app.basic_ecom.adapter.output;
import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Component;

import com.example.ecom_app.basic_ecom.domain.ports.output.PasswordEncoderPort;

@Component
public class PasswordEncoderAdapter implements PasswordEncoderPort {
    
    private final PasswordEncoder passwordEncoder;
    
    public PasswordEncoderAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
    
    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}