package com.example.bringoChargeRestApi.controller;

import com.example.bringoChargeRestApi.entity.Reservation;
import com.example.bringoChargeRestApi.entity.User;
import com.example.bringoChargeRestApi.service.ReservationService;
import com.example.bringoChargeRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation_form";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation, Principal principal) {
        // Get the currently authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();  // assuming the username is the email
        User user = userService.findUserByEmail(principal.getName());

        // Set the user to the reservation
        reservation.setUser(user);

        // Save the reservation
        reservationService.saveReservation(reservation);

        return "redirect:/dashboard"; // Redirect to dashboard after saving the reservation
    }

    @GetMapping
    public String listReservations(Model model, Principal principal) {
        try {
            // Get the currently authenticated user
            String userEmail = principal.getName();
            User user = userService.findUserByEmail(userEmail);

            // Fetch reservations for the current user
            List<Reservation> reservations = reservationService.getReservationsByUser(user);

            // Format the reservation date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (Reservation reservation : reservations) {
                if (reservation.getReservationDate() != null) {
                    reservation.setFormattedReservationDate(formatter.format(reservation.getReservationDate()));
                } else {
                    reservation.setFormattedReservationDate("N/A");
                }
            }

            model.addAttribute("reservations", reservations);
            return "reservation_list"; // Ensure this matches your HTML file name
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            model.addAttribute("errorMessage", "An error occurred while fetching reservations.");
            return "error"; // Ensure you have an error.html to display this message
        }
    }
}
