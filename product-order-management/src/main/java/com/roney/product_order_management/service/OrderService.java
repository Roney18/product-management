package com.roney.product_order_management.service;

import com.roney.product_order_management.config.ModelMapperConfig;
import com.roney.product_order_management.dto.OrderResponseDto;
import com.roney.product_order_management.exception.ResourceNotFoundException;
import com.roney.product_order_management.model.Customer;
import com.roney.product_order_management.model.Order;
import com.roney.product_order_management.model.Product;
import com.roney.product_order_management.repo.CustomerRepo;
import com.roney.product_order_management.repo.OrderRepo;
import com.roney.product_order_management.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;

    public OrderResponseDto createOrder(Integer customerId, List<Integer> productIds) throws ResourceNotFoundException {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Not Found"));

        List<Product> products = productRepo.findAllById(productIds);
        if (products.isEmpty())
            throw new ResourceNotFoundException("No products found for given IDs");

        double total = products.stream().mapToDouble(Product::getPrice).sum();

        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setOrderDate(new Date());
        order.setTotalAmount(total);
        order.setOrderStatus(Order.OrderStatus.NEW);

        Order saved = orderRepo.save(order);

        return mapToDto(saved);
    }



    private OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = mapper.map(order, OrderResponseDto.class);
        dto.setProductIds(order.getProducts().stream().map(Product::getId).toList());
        dto.setCustomerId(order.getCustomer().getId());
        return dto;
    }

    public OrderResponseDto getOrder(Integer id) throws ResourceNotFoundException {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return mapToDto(order);

    }

    public OrderResponseDto cancelOrder(Integer id) throws ResourceNotFoundException {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setOrderStatus(Order.OrderStatus.CANCELLED);
        Order updated = orderRepo.save(order);
        return mapToDto(updated);
    }
}
