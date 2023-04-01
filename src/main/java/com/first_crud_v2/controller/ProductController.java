package com.first_crud_v2.controller;

import com.first_crud_v2.entity.Product;
import com.first_crud_v2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/get/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return service.getProductById(productId);
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/post")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public Product deleteProduct(@PathVariable int productId) {
        return service.deleteProduct(productId);
    }
}
