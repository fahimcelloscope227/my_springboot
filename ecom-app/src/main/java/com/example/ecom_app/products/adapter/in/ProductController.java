package com.example.ecom_app.products.adapter.in;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_app.basic_ecom.adapter.input.dto.ApiResponse;
import com.example.ecom_app.basic_ecom.domain.dto.Category;
import com.example.ecom_app.products.adapter.dto.CreateProductRequest;
import com.example.ecom_app.products.adapter.dto.ProductResult;
import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.in.CreateProductUseCase;
import com.example.ecom_app.products.domain.port.in.GetProductsUseCase;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class ProductController {
        private final GetProductsUseCase getProductsUseCase;
        private final CreateProductUseCase createProductUseCase;

        public ProductController(GetProductsUseCase getProductsUseCase,
                        CreateProductUseCase createProductUseCase) {
                this.getProductsUseCase = getProductsUseCase;
                this.createProductUseCase = createProductUseCase;
        }

        @GetMapping({ "/products", "/products/" })
        public ResponseEntity<ApiResponse> getAllProducts() {
                List<Product> products = getProductsUseCase.getAllProducts();

                List<ProductResult> results = products.stream()
                                .map(product -> ProductResult.builder()
                                                .id(product.getId())
                                                .name(product.getName())
                                                .description(product.getDescription())
                                                .price(product.getPrice())
                                                .stockQuantity(product.getStockQuantity())
                                                .imageUrl(product.getImageUrl())
                                                .category(product.getCategory())
                                                .isActive(product.getIsActive())
                                                .createdAt(product.getCreatedAt())
                                                .updatedAt(product.getUpdatedAt())
                                                .build())
                                .toList();

                return ResponseEntity.ok(ApiResponse.builder()
                                .success(true)
                                .message("Products retrieved successfully")
                                .data(results)
                                .build());
        }

        @PostMapping({ "/products", "/products/" })
        public ResponseEntity<ApiResponse> createProduct(@RequestBody CreateProductRequest request) {
                // Map request DTO to domain object
                Product product = Product.builder()
                                .name(request.getName())
                                .description(request.getDescription())
                                .price(request.getPrice())
                                .stockQuantity(request.getStockQuantity())
                                .imageUrl(request.getImageUrl())
                                .category(request.getCategoryId() != null
                                                ? Category.builder().id(request.getCategoryId()).build()
                                                : null)
                                .build();

                Product savedProduct = createProductUseCase.createProduct(product);

                ProductResult result = ProductResult.builder()
                                .id(savedProduct.getId())
                                .name(savedProduct.getName())
                                .description(savedProduct.getDescription())
                                .price(savedProduct.getPrice())
                                .stockQuantity(savedProduct.getStockQuantity())
                                .imageUrl(savedProduct.getImageUrl())
                                .isActive(savedProduct.getIsActive())
                                .createdAt(savedProduct.getCreatedAt())
                                .updatedAt(savedProduct.getUpdatedAt())
                                .build();

                return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.builder()
                                .success(true)
                                .message("Product created successfully")
                                .data(result)
                                .build());
        }
}
