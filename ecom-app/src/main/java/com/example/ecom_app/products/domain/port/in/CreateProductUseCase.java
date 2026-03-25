package com.example.ecom_app.products.domain.port.in;

import com.example.ecom_app.products.domain.dto.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
