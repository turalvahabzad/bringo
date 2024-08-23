package com.example.bringoChargeRestApi.repository;

import com.example.bringoChargeRestApi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}