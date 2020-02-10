package com.example.shirodemo.sevice;

import com.example.shirodemo.domain.User;

public interface UserService {
    public User findByName(String username);
    public User findById(Long id);
}
