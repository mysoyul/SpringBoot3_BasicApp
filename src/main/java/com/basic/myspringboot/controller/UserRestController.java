package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.entity.Users;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping
    public User save(@RequestBody User userEntity) {
        return userService.insert(userEntity);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public User findUserById(@PathVariable Long id) {
        return userService.selectById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> findUsers() {
        return userService.selectAll();
    }

    @GetMapping(value="/xml", produces = {"application/xml"})
    public Users getUsersXml() {
        Users users = new Users();
        users.setUsers(userService.selectAll());
        return users;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
        return userService.update(id, userDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(id + " User Deleted...");
    }
}
