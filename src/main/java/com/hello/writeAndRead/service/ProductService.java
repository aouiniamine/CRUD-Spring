package com.hello.writeAndRead.service;

import com.hello.writeAndRead.entity.Product;
import com.hello.writeAndRead.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> takeProducts(int id, int quantity){
        Product product = repository.findById(id).orElse(null);

        if (product != null){
            if(quantity > product.quantity){
                return  new ResponseEntity<>("Inventory doesn't have that much product", HttpStatus.BAD_REQUEST);
            }
            product.quantity -= quantity;
            try{
                repository.save(product);
                return new ResponseEntity<>("Product is taken!!", HttpStatus.OK);
            } catch (Error error){
                return new ResponseEntity<>(error.getMessage(), HttpStatus.EXPECTATION_FAILED);
            }



        } else return new ResponseEntity<>("Product not found",
                HttpStatus.NOT_FOUND);
    }


}
