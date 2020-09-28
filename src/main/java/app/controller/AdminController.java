package app.controller;

import app.model.Hotel;
import app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private HotelService hotelService;

    @Autowired
    public AdminController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/management")
    public String managementPage() {
        return "management";
    }

    @GetMapping("/hotels")
    public String findAllHotels(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);

        return "hotel-list-admin";
    }
}
