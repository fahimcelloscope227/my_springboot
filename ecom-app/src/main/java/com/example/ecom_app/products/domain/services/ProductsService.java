package com.example.ecom_app.products.domain.services;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.event.ProductSavedEvent;
import com.example.ecom_app.products.domain.port.in.CreateProductUseCase;
import com.example.ecom_app.products.domain.port.in.GetProductsUseCase;
import com.example.ecom_app.products.domain.port.out.ProductsRepositoryPort;

@Service
public class ProductsService implements GetProductsUseCase, CreateProductUseCase {

    private final ProductsRepositoryPort productsRepositoryPort;
    private final ApplicationEventPublisher eventPublisher;

    public ProductsService(ProductsRepositoryPort productsRepositoryPort,
                           ApplicationEventPublisher eventPublisher) {
        this.productsRepositoryPort = productsRepositoryPort;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepositoryPort.getAllProducts();
    }

    /**
     * Creates a product within a transaction.
     * After the product is saved, publishes a ProductSavedEvent.
     * The @TransactionalEventListener in ProductSavedEventListener
     * will only fire AFTER this transaction commits successfully.
     */
    @Override
    @Transactional
    public Product createProduct(Product product) {
        Product savedProduct = productsRepositoryPort.saveProduct(product);

        // Publish event — the listener will fire after commit
        eventPublisher.publishEvent(new ProductSavedEvent(this, savedProduct));

        return savedProduct;
    }
}
