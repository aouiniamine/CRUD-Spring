package com.hello.writeAndRead.controller;

import com.hello.writeAndRead.entity.Product;
import com.hello.writeAndRead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/saveProduct")
    public Product saveProduct(Product product){
        return service.save(product);
    }


}
