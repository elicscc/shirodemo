package com.example.shirodemo.sevice.impl;

import com.example.shirodemo.domain.User;
import com.example.shirodemo.mapper.UserMapper;
import com.example.shirodemo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
