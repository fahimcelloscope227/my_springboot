package com.example.ecom_app.products.adapter.out.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom_app.products.adapter.out.entities.ProductEntity;

@Repository
public interface SpringDataProductRepisotory extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();

}
