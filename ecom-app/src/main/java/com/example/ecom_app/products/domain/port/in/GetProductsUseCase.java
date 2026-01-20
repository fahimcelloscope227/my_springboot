
package com.example.ecom_app.products.domain.port.in;

import java.util.List;

import  com.example.ecom_app.products.domain.dto.Product;

public interface GetProductsUseCase {
    public List<Product> getAllProducts();
}
