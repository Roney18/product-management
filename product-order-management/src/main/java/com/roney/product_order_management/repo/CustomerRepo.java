package com.roney.product_order_management.repo;

import com.roney.product_order_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
