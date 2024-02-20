package com.hello.writeAndRead.repository;

import com.hello.writeAndRead.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
