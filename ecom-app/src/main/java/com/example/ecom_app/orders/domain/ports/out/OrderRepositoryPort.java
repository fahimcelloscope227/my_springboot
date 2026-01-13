package com.example.ecom_app.orders.domain.ports.out;

import com.example.ecom_app.orders.domain.dto.FoodOrder;

public interface OrderRepositoryPort {

    void saveOrder(FoodOrder order);

    String findOrderById(String orderId);

}
