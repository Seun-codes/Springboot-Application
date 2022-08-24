package com.Elizabeth.eccomerceStore1.repositories;

import com.Elizabeth.eccomerceStore1.entitites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByName(String name);


}
