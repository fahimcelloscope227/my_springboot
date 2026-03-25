package com.example.ecom_app.products.domain.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Listener for ProductSavedEvent.
 * Uses @TransactionalEventListener so this method executes
 * ONLY AFTER the transaction that saved the product is committed.
 * 
 * This is useful for side effects like:
 *  - Sending notifications (email, SMS, push)
 *  - Updating search indexes
 *  - Publishing to a message broker (Kafka, RabbitMQ)
 *  - Clearing/invalidating caches
 */
@Slf4j
@Component
public class ProductSavedEventListener {

    /**
     * Handles the ProductSavedEvent after the transaction commits.
     * If the transaction rolls back, this listener will NOT execute.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleProductSavedEvent(ProductSavedEvent event) {
        log.info("========== TransactionalEventListener triggered ==========");
        log.info("Product saved successfully! Transaction committed.");
        log.info("Product ID   : {}", event.getProduct().getId());
        log.info("Product Name : {}", event.getProduct().getName());
        log.info("Product Price: {}", event.getProduct().getPrice());
        log.info("==========================================================");

        // TODO: Add your post-commit side effects here, for example:
        // - notificationService.sendNewProductNotification(event.getProduct());
        // - searchIndexService.indexProduct(event.getProduct());
        // - kafkaProducer.send("product-topic", event.getProduct());
    }
}
