package com.Elizabeth.eccomerceStore1.repositories;

import com.Elizabeth.eccomerceStore1.entitites.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {

}
