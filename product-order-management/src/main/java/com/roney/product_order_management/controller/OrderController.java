package com.roney.product_order_management.controller;

import com.roney.product_order_management.dto.OrderRequestDto;
import com.roney.product_order_management.dto.OrderResponseDto;
import com.roney.product_order_management.dto.Summary;
import com.roney.product_order_management.exception.ResourceNotFoundException;
import com.roney.product_order_management.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("api/orders")
    public ResponseEntity<OrderResponseDto> saveOrder(@RequestBody OrderRequestDto requestDto){

        try{
            OrderResponseDto dto = service.createOrder(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (Exception e) {
            log.error("e: ", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("api/orders/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Integer id) {
       try{
           return ResponseEntity.ok(service.getOrder(id));
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @PutMapping("api/orders/{id}/cancel")
    public ResponseEntity<OrderResponseDto> cancelOrder(@PathVariable Integer id) throws ResourceNotFoundException {
        try{
            return ResponseEntity.ok(service.cancelOrder(id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("api/orders/summary")
    public ResponseEntity<Summary> getSummary() {
        return ResponseEntity.ok(service.getSummary());
    }

}
