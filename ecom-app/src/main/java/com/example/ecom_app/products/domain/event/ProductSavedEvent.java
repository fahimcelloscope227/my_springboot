package com.example.ecom_app.products.domain.event;

import com.example.ecom_app.products.domain.dto.Product;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event published after a product is saved to the database.
 * This event is consumed by @TransactionalEventListener to ensure
 * the listener runs only after the transaction is successfully committed.
 */
@Getter
public class ProductSavedEvent extends ApplicationEvent {

    private final Product product;

    public ProductSavedEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
