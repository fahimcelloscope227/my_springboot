package com.example.ecom_app.products.adapter.out;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ecom_app.products.adapter.out.entities.ProductEntity;
import com.example.ecom_app.products.adapter.out.repositories.SpringDataProductRepisotory;
import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.out.ProductsRepositoryPort;

@Repository
public class ProductRepositoryAdapter implements  ProductsRepositoryPort{

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
        return new Product(
            productEntity.getId(),
            productEntity.getName(),
            productEntity.getDescription(),
            productEntity.getPrice()
        );
    }

}
