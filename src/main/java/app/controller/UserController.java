package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "user-list";
    }

    @GetMapping("/{userId}/enable")
    public String enableUser(@PathVariable Long userId) {
        userService.enable(userId);

        return "redirect:/users/all";
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public void deleteById(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
