package app.controller;

import app.model.Hotel;
import app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/form")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String showForm(Model model) {
        model.addAttribute("hotel", new Hotel());

        return "hotel-form";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@ModelAttribute Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/admin/home";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public String findAll(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);

        return "hotel-list";
    }

    @GetMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.OK)
    public String findOne(@PathVariable Long hotelId, Model model) {
        Hotel foundHotel = hotelService.findOne(hotelId);
        model.addAttribute("hotel", foundHotel);
        model.addAttribute("rooms", foundHotel.getRooms());

        return "hotel";
    }

    @DeleteMapping("/{hotelId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteById(@PathVariable Long hotelId) {
        hotelService.deleteById(hotelId);

        return "redirect:admin/hotels";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String findByCountry(@RequestParam("country") String country, Model model) {
        List<Hotel> foundHotels = hotelService.findByCountry(country);
        model.addAttribute("hotels", foundHotels);

        return "hotel-list";
    }
}
