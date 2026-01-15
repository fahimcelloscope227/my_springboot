package com.example.ecom_app.basic_ecom.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Set<String> roles = new HashSet<>();
    private Boolean isEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Boolean isActive() {
        return isEnabled != null && isEnabled;
    }
    
    public Boolean isPasswordMatched(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

}
