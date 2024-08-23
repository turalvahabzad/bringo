package com.example.bringoChargeRestApi.repository;

import com.example.bringoChargeRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
