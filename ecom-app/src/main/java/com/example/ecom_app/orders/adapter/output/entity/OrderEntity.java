package com.example.ecom_app.orders.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private String orderId;

    private String customerName;
    private String restaurantName;
    private String item;
    private String status;
    
    // Default constructor
    public OrderEntity() {
    }
    
    // Parameterized constructor
    public OrderEntity(String orderId, String customerName, String restaurantName, String item, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.item = item;
        this.status = status;
    }

    // Getter and Setter for orderId
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    // Getter and Setter for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and Setter for restaurantName
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    // Getter and Setter for item
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
