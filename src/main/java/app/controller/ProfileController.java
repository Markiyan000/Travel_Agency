package app.controller;

import app.model.Booking;
import app.model.User;
import app.service.BookingService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profiles")
public class ProfileController {

    private UserService userService;

    private BookingService bookingService;

    @Autowired
    public ProfileController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{username}")
    public String userProfile(@PathVariable String username, Model model) {
        User user = userService.findByUsername(username);
        List<Booking> bookings = bookingService.findByUser(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("bookings", bookings);

        return "user-profile";
    }
}
