package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.DTO.UserDto;
import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import com.Elizabeth.eccomerceStore1.entitites.User;

import java.util.List;

public interface UserService {


    User create(UserDto userDto);
    public List<User> getAll();
    public User findUserById(Long id);
    public User login(User user);
    public User updateUser(User user);

    public Boolean deleteUser(Long id);



    User findUserByEmail(String email);
    User Login(String email, String password);

    User findByName(String username);

    List<CartItem> getCart(String email);









}
