package com.Elizabeth.eccomerceStore1.serviceImplimentation;

import com.Elizabeth.eccomerceStore1.entitites.Cart;
import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.repositories.CartItemRepository;
import com.Elizabeth.eccomerceStore1.repositories.CartRepository;
import com.Elizabeth.eccomerceStore1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    CartItemRepository cartItemRepository;

    @Override
    public Cart addItemToCart(Product product, int quantity, User user) {

        Cart cart = user.getCart();

        if(cart == null){
            cart = new Cart();
        }
        Set<CartItem> cartItems = cart.getCartItem();
        CartItem cartItem = findCartItem(cartItems, product.getProductId());
        if(cartItems == null){
            cartItems = new HashSet<>();
            if(cartItem == null){
                cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getPrice());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                cartItemRepository.save(cartItem);
            }
        }else{
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setTotalPrice(cartItem.getTotalPrice() + (quantity * product.getPrice()));
            cartItemRepository.save(cartItem);
        }


        cart.setCartItem(cartItems);

        int totalItems = totalItems(cart.getCartItem());
        double totalPrice = totalPrice(cart.getCartItem());

        cart.setTotalPrices(totalPrice);
        cart.setTotalItems(totalItems);
        cart.setUser(user);

        return cartRepository.save(cart);

    }

    @Override
    public Cart deleteItemFromCart(Product product, User user) {

        Cart cart = user.getCart();
        Set<CartItem> cartItems = cart.getCartItem();
        CartItem item = findCartItem(cartItems, product.getProductId());
        cartItems.remove(item);
        cartItemRepository.delete(item);

        double totalPrice = totalPrice(cartItems);
        int totalItems = totalItems(cartItems);

        cart.setCartItem(cartItems);
        cart.setTotalItems(totalItems);
        cart.setTotalPrices(totalPrice);

        return cartRepository.save(cart);

    }




    private CartItem findCartItem(Set<CartItem> cartItems, Long productId){
        if(cartItems == null){
            return  null;
        }
            CartItem cartItem = null;

            for(CartItem item : cartItems){
                if(item.getProduct().getProductId() == productId){
                    cartItem =item;
                }
            }


        return cartItem;
    }


    private int totalItems(Set<CartItem> cartItems){
        int totalItems = 0;
        for(CartItem items : cartItems){
            totalItems +=items.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<CartItem> cartItems){
        double totalPrice =0.0;
        for(CartItem item : cartItems){
            totalPrice+=item.getTotalPrice();
        }
        return totalPrice;
    }

//    public List<CartItem> getCart(String email) {
//        return cartItemRepository.findByEmail(email).orElseThrow(()->
//                new CustomAppException("Nothing Found"));
//    }


}
