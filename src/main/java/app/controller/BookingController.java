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
import java.time.LocalDate;

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

    @GetMapping("/room/{roomId}/available/form")
    public String checkAvailableRoomsForm(@PathVariable Long roomId, Model model) {
        model.addAttribute("roomId", roomId);

        return "available-rooms-form";
    }

    @PostMapping("/room/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public String bookRoom(@PathVariable Long roomId, @ModelAttribute Booking booking, Principal principal, Model model) {
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
