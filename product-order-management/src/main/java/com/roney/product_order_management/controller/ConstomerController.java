package com.roney.product_order_management.controller;

import com.roney.product_order_management.model.Customer;
import com.roney.product_order_management.service.CustomerService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("api/customer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        try {
            Customer cust = service.saveCust(customer);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
