package com.roney.product_order_management.service;

import com.roney.product_order_management.model.Product;
import com.roney.product_order_management.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getALl() {
        List<Product> products = repo.findAll();
        return  products;
    }

    public Product save(Product product) {
        return repo.save(product);
    }
}
