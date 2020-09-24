package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public String signUpForm(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/";
    }
}
