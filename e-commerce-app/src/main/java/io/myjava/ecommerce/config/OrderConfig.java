package io.myjava.ecommerce.config;

import io.myjava.ecommerce.domain.service.OrderService;
import io.myjava.ecommerce.domain.ports.out.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService foodOrderService(OrderRepositoryPort orderRepository) {
        return new OrderService(orderRepository);
    }

}
