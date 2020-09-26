package app.controller;

import app.model.Booking;
import app.model.User;
import app.service.BookingService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    private UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping("/room/{roomId}/form")
    public String bookingForm(@PathVariable Long roomId, Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("booking", new Booking());

        return "booking-form";
    }

    @PostMapping("/room/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public String bookRoom(@PathVariable Long roomId, @ModelAttribute Booking booking, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        booking.setUser(user);

        bookingService.save(booking, roomId);

        return "home";
    }

}
