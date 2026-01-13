package com.example.ecom_app.orders.adapter.output.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom_app.orders.adapter.output.entity.OrderEntity;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String> {
}