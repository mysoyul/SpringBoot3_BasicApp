package com.basic.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/leaf")
    public String leaf(Model model) {
        model.addAttribute("name","basic");
        return "leaf";
    }

}
