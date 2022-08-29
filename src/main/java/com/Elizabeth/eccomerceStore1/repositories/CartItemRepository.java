package com.Elizabeth.eccomerceStore1.repositories;

import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItem, Long> {
    List<CartItem> findByEmail(String email);
}
