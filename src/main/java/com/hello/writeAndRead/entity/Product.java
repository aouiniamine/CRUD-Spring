package com.hello.writeAndRead.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;

    public int getQuantity(){
        return quantity;
    }
    public void takeProducts(int productsTaken){
        quantity -= productsTaken;
    }
}
