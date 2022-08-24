package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.entitites.Cart;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;

public interface CartService {
    Cart addItemToCart(Product product, int quantity, User user);

    Cart deleteItemFromCart(Product product, User user);


}
