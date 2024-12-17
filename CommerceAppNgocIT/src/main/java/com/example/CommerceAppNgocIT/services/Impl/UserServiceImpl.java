package com.example.CommerceAppNgocIT.services.Impl;

import com.example.CommerceAppNgocIT.models.User;
import com.example.CommerceAppNgocIT.repositorys.UserRepository;
import com.example.CommerceAppNgocIT.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
