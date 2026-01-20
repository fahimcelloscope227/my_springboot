package com.example.ecom_app.products.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_app.basic_ecom.adapter.input.dto.ApiResponse;
import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.in.GetProductsUseCase;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class ProductController {
    private final GetProductsUseCase getProductsUseCase;

    public ProductController(GetProductsUseCase getProductsUseCase) {
        this.getProductsUseCase = getProductsUseCase;
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = getProductsUseCase.getAllProducts();
 
        return ResponseEntity.ok(ApiResponse.builder()
        .success(true)
        .message("Products retrieved successfully")
        .data(products)
        .build());
    }

}
