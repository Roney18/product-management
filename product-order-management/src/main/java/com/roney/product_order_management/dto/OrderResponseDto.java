package com.roney.product_order_management.dto;

import com.roney.product_order_management.model.Order;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponseDto {

    private Integer id;
    private Date orderDate;
    private Integer customerId;
    private List<Integer> productIds;
    private Double totalAmount;
    private Order.OrderStatus status;

}
