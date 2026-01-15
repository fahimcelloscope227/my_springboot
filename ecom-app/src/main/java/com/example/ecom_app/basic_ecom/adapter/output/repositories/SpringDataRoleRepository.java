package com.example.ecom_app.basic_ecom.adapter.output.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecom_app.basic_ecom.adapter.output.entities.RoleEntity;

import java.util.Optional;

@Repository
public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
