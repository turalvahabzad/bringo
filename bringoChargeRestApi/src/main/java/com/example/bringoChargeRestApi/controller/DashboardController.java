package com.example.bringoChargeRestApi.controller;

import com.example.bringoChargeRestApi.entity.Reservation;
import com.example.bringoChargeRestApi.entity.User;
import com.example.bringoChargeRestApi.service.ReservationService;
import com.example.bringoChargeRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showDashboard(Model model, Principal principal) {
        try {
            String userEmail = principal.getName();
            User user = userService.findUserByEmail(userEmail);
            List<Reservation> reservations = reservationService.getReservationsByUser(user);

            model.addAttribute("reservations", reservations);
            return "dashboard"; // Ensure this matches your HTML file name
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            model.addAttribute("errorMessage", "An error occurred while fetching reservations.");
            return "error"; // Ensure you have an error.html to display this message
        }
    }
}
