package com.Elizabeth.eccomerceStore1.serviceImplimentation;

import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findByProductId(id);
    }

    @Override
    public Product saveProduct(Product product) {
        Product saveProduct =productRepository.save(product);
        return productRepository.save(saveProduct);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        if(this.findProductById(id) == null){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
