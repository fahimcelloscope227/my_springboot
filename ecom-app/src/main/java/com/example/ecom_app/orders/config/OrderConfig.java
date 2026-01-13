package com.example.ecom_app.orders.config;

import com.example.ecom_app.orders.domain.service.OrderService;
import com.example.ecom_app.orders.domain.ports.out.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService foodOrderService(OrderRepositoryPort orderRepository) {
        return new OrderService(orderRepository);
    }

}
