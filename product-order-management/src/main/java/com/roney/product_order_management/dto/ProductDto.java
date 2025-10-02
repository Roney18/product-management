package com.roney.product_order_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Integer id;
    @NotBlank
    private String name;
    private String category;
    @NotNull
    private Double price;
}
