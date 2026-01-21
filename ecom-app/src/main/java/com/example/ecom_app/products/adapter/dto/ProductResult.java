package com.example.ecom_app.products.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.example.ecom_app.basic_ecom.domain.dto.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResult {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String imageUrl;
    private Category category;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
