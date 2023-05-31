package com.basic.myspringboot.service;

import com.basic.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    //@Autowired
    private final UserRepository userRepository;

    //Constructor Injection
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
}
