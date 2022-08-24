package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.entitites.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User findUserById(Long id);
    public User saveUser(User user);
    public User updateUser(User user);
    public Boolean deleteUser(Long id);



}
