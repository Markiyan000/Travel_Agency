package app.controller;

import app.model.Room;
import app.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{hotelId}/form")
    public String showForm(@PathVariable Long hotelId, Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("hotelId", hotelId);

        return "room-form";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/{hotelId}")
    public String saveRoom(@PathVariable Long hotelId, @ModelAttribute Room room) {
        roomService.save(hotelId, room);

        return "redirect:/" + hotelId;
    }

}
