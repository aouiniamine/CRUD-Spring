package com.hello.writeAndRead.controller;

import com.hello.writeAndRead.entity.Product;
import com.hello.writeAndRead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class TakeProductBody{
    public int id;
    public int quantity;
}
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return service.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProudcts(){
        return service.getAllProducts();
    }

    @GetMapping("/byId/{id}")
    public Product getProudctById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PutMapping("/take")
    public ResponseEntity<String> takeProducts(@RequestBody TakeProductBody body){
        System.out.println(body.id + " " + body.quantity);
        return service.takeProducts(body.id, body.quantity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
