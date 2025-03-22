package com.training.springapp; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.training.springapp.controller") 
public class ProductappApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductappApplication.class, args);
    }
}
