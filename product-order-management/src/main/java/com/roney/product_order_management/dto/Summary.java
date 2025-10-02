package com.roney.product_order_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Summary {

    private Long totalOrders;
    private Double revenue;
}
