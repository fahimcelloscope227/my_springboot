package com.example.ecom_app.basic_ecom.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Order {
    private Long id;
    private Long userId;
    private List<OrderItem> items = new ArrayList<>();
    private BigDecimal totalAmount;
    private OrderStatusEnum status;
    private String shippingAddress;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

}




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class OrderItem {
    
    private Long id;
    private Long productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
}