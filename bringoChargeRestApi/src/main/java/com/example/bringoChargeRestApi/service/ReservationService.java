package com.example.bringoChargeRestApi.service;

import com.example.bringoChargeRestApi.entity.Reservation;
import com.example.bringoChargeRestApi.entity.User;
import com.example.bringoChargeRestApi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Add this method to fetch reservations by user
    public List<Reservation> getReservationsByUser(User user) {
        return reservationRepository.findByUser(user);
    }
}
