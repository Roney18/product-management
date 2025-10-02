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


    @NotNull
    private Integer customerId;
    @NotEmpty
    private List<Integer> products;
}
