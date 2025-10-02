package com.roney.product_order_management.repo;


import com.roney.product_order_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
