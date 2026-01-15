package com.example.ecom_app.basic_ecom.adapter.input.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// ==================== REQUEST DTOs ====================

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String name;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
    
    private String phoneNumber;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank
    private String name;
    
    private String description;
    
    @NotNull
    @Positive
    private BigDecimal price;
    
    @NotNull
    @Positive
    private Integer stockQuantity;
    
    @NotNull
    private Long categoryId;
    
    private String imageUrl;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {
    @NotNull
    private Long productId;
    
    @NotNull
    @Positive
    private Integer quantity;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {
    @NotBlank
    private String shippingAddress;
}

// ==================== RESPONSE DTOs ====================

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private Long userId;
    private String email;
    private String name;
}
