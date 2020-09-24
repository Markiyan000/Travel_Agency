package app.controller;

import app.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @PostMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("room", new Room());

        return "room_form";
    }
}
