package com.example.shirodemo.mapper;

import com.example.shirodemo.domain.User;

public interface UserMapper {
    public User findByName(String username);
    public User findById(Long id);
}
