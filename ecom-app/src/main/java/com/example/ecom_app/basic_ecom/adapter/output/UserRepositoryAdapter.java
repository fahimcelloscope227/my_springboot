package com.example.ecom_app.basic_ecom.adapter.output;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.ecom_app.basic_ecom.adapter.output.entities.RoleEntity;
import com.example.ecom_app.basic_ecom.adapter.output.entities.UserEntity;
import com.example.ecom_app.basic_ecom.adapter.output.repositories.SpringDataRoleRepository;
import com.example.ecom_app.basic_ecom.adapter.output.repositories.SpringDataUserRepository;
import com.example.ecom_app.basic_ecom.domain.dto.User;
import com.example.ecom_app.basic_ecom.domain.ports.output.UserRepositoryPort;

public class UserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataRoleRepository springDataRoleRepository;
    private final SpringDataUserRepository springDataUserRepository;

    public UserRepositoryAdapter(SpringDataRoleRepository springDataRoleRepository,
                          SpringDataUserRepository springDataUserRepository) {
        this.springDataRoleRepository = springDataRoleRepository;
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = toEntity(user);
        springDataUserRepository.save(userEntity);
        return toDomain(userEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        springDataUserRepository.findByEmail(email);
        return springDataUserRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return  springDataUserRepository.existsByEmail(email);
    }

    private UserEntity toEntity(User user) {
        var roles = user.getRoles().stream()
                .map(roleName -> springDataRoleRepository.findByName(roleName)
                        .orElseGet(() -> springDataRoleRepository.save(new RoleEntity(null, roleName)))).collect(Collectors.toSet());
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .roles(roles)
                .isEnabled(user.getIsEnabled())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

     private User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .roles(entity.getRoles().stream()
                        .map(RoleEntity::getName)
                        .collect(Collectors.toSet()))
                .isEnabled(entity.getIsEnabled())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
