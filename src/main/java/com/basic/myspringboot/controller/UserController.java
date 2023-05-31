package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userList")
    public String index(Model model) {
        model.addAttribute("users", userService.selectAll());
        return "index";
    }

    @GetMapping("/leaf")
    public String leaf(Model model) {
        model.addAttribute("name","타임리프");
        return "leaf";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.insert(user);
        model.addAttribute("users", userService.selectAll());
        return "index";
    }
}
