package com.example.bringoChargeRestApi.repository;

import com.example.bringoChargeRestApi.entity.Reservation;
import com.example.bringoChargeRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser(User user); // Query method to find reservations by user
}
