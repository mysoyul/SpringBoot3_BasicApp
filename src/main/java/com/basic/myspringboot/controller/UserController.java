package com.basic.myspringboot.controller;

import com.basic.myspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userService.selectAll());
        return "index";
    }


    @GetMapping("/leaf")
    public String leaf(Model model) {
        model.addAttribute("name","타임리프");
        return "leaf";
    }

}
