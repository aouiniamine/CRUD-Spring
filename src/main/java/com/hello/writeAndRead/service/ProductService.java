package com.hello.writeAndRead.service;

import com.hello.writeAndRead.entity.Product;
import com.hello.writeAndRead.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public Product save(Product product){
        System.out.println(product);
        return repository.save(product);
    }
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }


}
