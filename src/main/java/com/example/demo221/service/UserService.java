package com.example.demo221.service;


import com.example.demo221.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}