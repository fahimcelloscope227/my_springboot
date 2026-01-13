package io.myjava.ecommerce.domain.service;

import io.myjava.ecommerce.domain.ports.in.PlaceOrderUsecase;
import io.myjava.ecommerce.domain.ports.in.TrackOrderUsecase;
import io.myjava.ecommerce.domain.ports.out.OrderRepositoryPort;
import io.myjava.ecommerce.domain.model.FoodOrder;

public class OrderService implements PlaceOrderUsecase, TrackOrderUsecase {

    private final OrderRepositoryPort orderRepository;

    OrderService(OrderRepositoryPort orderRepository) {
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

        return orderRepository.findById(orderId);
    }

}
