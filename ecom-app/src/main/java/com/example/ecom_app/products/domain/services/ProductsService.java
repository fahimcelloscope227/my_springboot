package com.example.ecom_app.products.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.in.GetProductsUseCase;
import com.example.ecom_app.products.domain.port.out.ProductsRepositoryPort;

@Service
public class ProductsService  implements  GetProductsUseCase{

    private final ProductsRepositoryPort productsRepositoryPort;

   public ProductsService(ProductsRepositoryPort productsRepositoryPort) {
        this.productsRepositoryPort = productsRepositoryPort;
    } 

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productsRepositoryPort.getAllProducts();
        return products;
    }

}
