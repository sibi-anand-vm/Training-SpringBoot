package com.training.springapp.controller;

import org.springframework.web.bind.annotation.*;

import com.training.springapp.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        products.add(product);
        return "Product '" + product.getName() + "' created successfully!";
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        if (id >= 0 && id < products.size()) {
            return products.get(id);
        } else {
            throw new RuntimeException("Product not found!");
        }
    }

    // UPDATE - Update an existing product
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        if (id >= 0 && id < products.size()) {
            products.set(id, updatedProduct);
            return "Product updated successfully!";
        } else {
            throw new RuntimeException("Product not found!");
        }
    }

    // DELETE - Remove a product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (id >= 0 && id < products.size()) {
            products.remove(id);
            return "Product deleted successfully!";
        } else {
            throw new RuntimeException("Product not found!");
        }
    }
}
