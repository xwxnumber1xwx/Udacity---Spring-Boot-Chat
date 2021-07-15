package com.example.mvc_basics.controller;

import com.example.mvc_basics.model.User;
import com.example.mvc_basics.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView() {
        return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        String errorMessage = null;

        if (this.userService.userAlreadyExist(user.getUsername())) {
            errorMessage = "Username already exist";
        }

        if (errorMessage == null) {
            this.userService.createUser(user);
            return "login";
        } else {
            model.addAttribute("errorMessage", errorMessage );
        }
        return "signup";
    }

}
