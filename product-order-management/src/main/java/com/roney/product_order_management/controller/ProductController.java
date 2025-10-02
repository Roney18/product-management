package com.roney.product_order_management.controller;

import com.roney.product_order_management.model.Product;
import com.roney.product_order_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("api/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = service.getALl();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping ("api/products")
    public ResponseEntity<?> savePorduct(@RequestBody Product product){
       try{
           Product p = service.save(product);
           return ResponseEntity.ok(product);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }


    }




}
