package com.roney.product_order_management.service;

import com.roney.product_order_management.model.Customer;
import com.roney.product_order_management.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCust(Customer customer) {
        return customerRepo.save(customer);
    }
}
