package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.entitites.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product findProductById(Long id);
   public Product saveProduct(Product product);
   public Product updateProduct(Product product);
   public Boolean deleteProduct(Long id);

}
