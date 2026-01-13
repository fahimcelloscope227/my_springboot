package com.example.ecom_app.orders.adapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecom_app.orders.adapter.output.entity.OrderEntity;
import com.example.ecom_app.orders.adapter.output.repository.SpringDataOrderRepository;
import com.example.ecom_app.orders.domain.dto.FoodOrder;
import com.example.ecom_app.orders.domain.ports.out.OrderRepositoryPort;


@Repository
public class JPAOrderRepository implements OrderRepositoryPort {

    @Autowired
    private SpringDataOrderRepository repository;

    public JPAOrderRepository(SpringDataOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveOrder(FoodOrder order) {
        repository.save(mapToEntity(order));
    }

    @Override
    public String findOrderById(String orderId) {
        // Implementation for finding order by ID using JPA
        OrderEntity entity = repository.findById(orderId).orElseThrow();
        FoodOrder order = mapToDomain(entity);
        return order.getStatus();
    }

    private OrderEntity mapToEntity(FoodOrder order) {
        // Mapping logic from FoodOrder to OrderEntity
        OrderEntity entity = new OrderEntity();
        // Set properties from order to entity
        entity.setOrderId(order.getOrderId());
        entity.setCustomerName(order.getCustomerName());
        entity.setRestaurantName(order.getRestaurantName());
        entity.setItem(order.getItem());
        entity.setStatus(order.getStatus());

        return entity;
    }

    private FoodOrder mapToDomain(OrderEntity entity) {
        // Mapping logic from OrderEntity to FoodOrder
        FoodOrder order = new FoodOrder();
        // Set properties from entity to order
        order.setOrderId(entity.getOrderId());
        order.setCustomerName(entity.getCustomerName());
        order.setRestaurantName(entity.getRestaurantName());
        order.setItem(entity.getItem());
        order.setStatus(entity.getStatus());

        return order;
    }

}
