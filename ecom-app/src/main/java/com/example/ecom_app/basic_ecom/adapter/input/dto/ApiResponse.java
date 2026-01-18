package com.example.ecom_app.basic_ecom.adapter.input.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;
}