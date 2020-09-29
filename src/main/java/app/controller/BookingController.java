package app.controller;

import app.dto.BookingDto;
import app.model.Booking;
import app.model.User;
import static app.message.Messages.*;
import app.service.BookingService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

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
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String bookingForm(@PathVariable Long roomId, Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("booking", new Booking());

        return "booking-form";
    }

    @GetMapping("/room/{roomId}/available/form")
    public String checkAvailableRoomsForm(@PathVariable Long roomId, Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("bookingDto", new BookingDto());

        return "available-rooms-form";
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findBookingByUser(@PathVariable Long userId, Model model) {
        List<Booking> bookings = bookingService.findByUser(userId);
        model.addAttribute("bookings", bookings);

        return "user-bookings";
    }

    @PostMapping("/room/{roomId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String bookRoom(@PathVariable Long roomId, @ModelAttribute("booking") @Valid Booking booking, BindingResult bindingResult,
                           Principal principal, Model model) {
        if (bindingResult.hasErrors()) {
            return "booking-form";
        }
        User user = userService.findByUsername(principal.getName());
        booking.setUser(user);

        if (bookingService.save(booking, roomId)) {
            model.addAttribute("positive", POSITIVE_BOOKING);
        } else {
            model.addAttribute("negative", NEGATIVE_BOOKING);
        }

        return "booking-form";
    }

    @GetMapping("room/{roomId}/available")
    public String checkAvailableRooms(@PathVariable Long roomId, @ModelAttribute("bookingDto") @Valid BookingDto bookingDto,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "available-rooms-form";
        }
        boolean isAvailable = bookingService.checkAvailableRooms(roomId, bookingDto);
        if (isAvailable) {
            model.addAttribute("positive", AVAILABLE_ROOM);
        } else {
            model.addAttribute("negative", NOT_AVAILABLE_ROOM);
        }

        return "available-rooms-form";
    }
}
