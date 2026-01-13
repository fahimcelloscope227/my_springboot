package com.example.ecom_app.orders.domain.ports.in;

import com.example.ecom_app.orders.domain.dto.FoodOrder;

public interface PlaceOrderUsecase {

    void placeOrder(FoodOrder order);

}
