package com.roney.product_order_management.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {


    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId;
    @NotEmpty(message = "Products list cannot be empty")
    private List<Integer> products;
}
