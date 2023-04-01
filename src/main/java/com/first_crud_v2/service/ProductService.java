package com.first_crud_v2.service;

import com.first_crud_v2.entity.Product;
import com.first_crud_v2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product getProductById(int productId) {
        return repository.findById(productId).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product newProduct) {
        return repository.save(newProduct);
    }

    public Product deleteProduct(int productId) {
        Product product = repository.findById(productId).orElse(null);

        repository.deleteById(productId);

        return product;
    }

    public Product updateProduct(Product newProduct) {
        Product product = repository.findById(newProduct.getId()).orElse(null);

        product.setName(newProduct.getName());
        product.setQuantity(newProduct.getQuantity());
        product.setPrice(newProduct.getPrice());

        return repository.save(product);
    }
}
