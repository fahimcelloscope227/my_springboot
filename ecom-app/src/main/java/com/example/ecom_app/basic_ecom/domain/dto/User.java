package com.example.ecom_app.basic_ecom.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    @Builder.Default
    private Set<String> roles = new HashSet<>();
    private Boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Boolean isActive() {
        return enabled != null && enabled;
    }

    public Boolean isPasswordMatched(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

}
