package com.basic.myspringboot.service;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public User insert(User userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<User> selectById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> selectAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User userDetail) {
        User existUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        existUser.setName(userDetail.getName());
        existUser.setEmail(userDetail.getEmail());
        return existUser;
    }
}
