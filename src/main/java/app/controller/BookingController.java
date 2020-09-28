package app.controller;

import app.model.Booking;
import app.model.User;
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
import java.time.LocalDate;
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
    @ResponseStatus(HttpStatus.OK)
    public String bookRoom(@PathVariable Long roomId, @ModelAttribute @Valid Booking booking,
                           Principal principal, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "booking-form";
        }
        User user = userService.findByUsername(principal.getName());
        booking.setUser(user);

        if (bookingService.save(booking, roomId)) {
            model.addAttribute("message", "Your order is successfully booked!");
        } else {
            model.addAttribute("message", "Your order is rejected :( There is no available rooms on this range of date");
        }

        return "booking-form";
    }

    @GetMapping("room/{roomId}/available")
    @ResponseBody
    public boolean checkAvailableRooms(@PathVariable Long roomId, @RequestParam("numberOfRooms") int numberOfRooms, @RequestParam("arrivalDate") String arrivalDate,  @RequestParam("departureDate") String departureDate) {
        return bookingService.checkAvailableRooms(roomId, LocalDate.parse(arrivalDate), LocalDate.parse(departureDate), numberOfRooms);
    }
}
