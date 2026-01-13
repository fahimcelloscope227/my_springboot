package com.example.ecom_app.orders.domain.service;

import com.example.ecom_app.orders.domain.dto.FoodOrder;

import com.example.ecom_app.orders.domain.ports.in.PlaceOrderUsecase;
import com.example.ecom_app.orders.domain.ports.in.TrackOrderUsecase;
import com.example.ecom_app.orders.domain.ports.out.OrderRepositoryPort;

public class OrderService implements PlaceOrderUsecase, TrackOrderUsecase {

    private final OrderRepositoryPort orderRepository;

    public OrderService(OrderRepositoryPort orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(FoodOrder order) {
        order.setStatus("PLACED");
        // Implementation for placing an order
        orderRepository.saveOrder(order);
    }

    @Override
    public String trackOrder(String orderId) {
        // Implementation for tracking an order

        return orderRepository.findOrderById(orderId);
    }

}
