package com.Elizabeth.eccomerceStore1.serviceImplimentation;

import com.Elizabeth.eccomerceStore1.DTO.UserDto;
import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.exception.CustomAppException;
import com.Elizabeth.eccomerceStore1.repositories.CartItemRepository;
import com.Elizabeth.eccomerceStore1.repositories.CartRepository;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.repositories.UserRepository;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Autowired
    private CartItemRepository cartItemRepository;



    @Override
    public User create(UserDto userDto) {

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());


        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User login(User user) {
        return null;
    }



    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        if(this.findUserById(id) == null){
            return  false;
        }
       userRepository.deleteById(id);
        return true;
    }




    @Override
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public User Login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email,password);

        return user;
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<CartItem> getCart(String email) {
        return cartItemRepository.findByEmail(email);
    }





}
