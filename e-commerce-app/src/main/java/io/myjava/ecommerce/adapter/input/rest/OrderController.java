package io.myjava.ecommerce.adapter.input.rest;

import org.springframework.web.bind.annotation.RestController;

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