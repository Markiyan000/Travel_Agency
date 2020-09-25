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
    @PostMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("room", new Room());

        return "room_form";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/{hotelId}")
    public String saveRoom(@PathVariable Long hotelId, @RequestBody Room room) {
        roomService.save(hotelId, room);

        return "redirect:/" + hotelId;
    }

}
