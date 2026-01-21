package com.example.ecom_app.products.adapter.out;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ecom_app.basic_ecom.domain.dto.Category;
import com.example.ecom_app.products.adapter.out.entities.CategoryEntity;
import com.example.ecom_app.products.adapter.out.entities.ProductEntity;
import com.example.ecom_app.products.adapter.out.repositories.SpringDataProductRepisotory;
import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.out.ProductsRepositoryPort;

@Repository
public class ProductRepositoryAdapter implements ProductsRepositoryPort {

    private final SpringDataProductRepisotory springDataProductRepisotory;

    public ProductRepositoryAdapter(SpringDataProductRepisotory springDataProductRepisotory) {
        this.springDataProductRepisotory = springDataProductRepisotory;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> allProducts = springDataProductRepisotory.findAll();
        return allProducts.stream().map(this::mapToDomain).toList();
    }

    private Product mapToDomain(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stockQuantity(productEntity.getStockQuantity())
                .imageUrl(productEntity.getImageUrl())
                .category(mapToCategoryDomain(productEntity.getCategory()))
                .isActive(productEntity.getIsActive())
                .createdAt(productEntity.getCreatedAt())
                .updatedAt(productEntity.getUpdatedAt())
                .build();
    }

    private Category mapToCategoryDomain(CategoryEntity categoryEntity) {
        if (categoryEntity == null)
            return null;
        return Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .createdAt(categoryEntity.getCreatedAt())
                .updatedAt(categoryEntity.getUpdatedAt())
                .build();
    }

}
