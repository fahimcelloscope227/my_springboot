package com.example.ecom_app.orders.adapter.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_app.orders.domain.dto.FoodOrder;
import com.example.ecom_app.orders.domain.ports.in.PlaceOrderUsecase;
import com.example.ecom_app.orders.domain.ports.in.TrackOrderUsecase;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUsecase placeOrderUsecase;
    private final TrackOrderUsecase trackOrderUsecase;

    public OrderController(PlaceOrderUsecase placeOrderUsecase, TrackOrderUsecase trackOrderUsecase) {
        this.placeOrderUsecase = placeOrderUsecase;
        this.trackOrderUsecase = trackOrderUsecase;
    }

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestBody FoodOrder order) {
        placeOrderUsecase.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/orders/{orderId}/track")
    public ResponseEntity<String> trackOrder(@PathVariable String orderId) {
        trackOrderUsecase.trackOrder(orderId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}