package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User userEntity) {
        return userService.insert(userEntity);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        Optional<User> optional = userService.selectById(id);
        User existUser = optional.orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
        return existUser;
    }


}
