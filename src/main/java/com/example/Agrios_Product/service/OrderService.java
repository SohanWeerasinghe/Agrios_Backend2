package com.example.Agrios_Product.service;



import com.example.Agrios_Product.model.Order;
import com.example.Agrios_Product.model.OrderDTO;
import com.example.Agrios_Product.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Save a new order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Fetch all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(OrderDTO orderDTO) {
        // Create a new Order entity from the OrderDTO
        Order order = new Order();
        order.setProductId(orderDTO.getProductId());  // Set the product ID (single product ID)
        order.setAddress(orderDTO.getDeliveryAddress());  // Set the delivery address

        // Save the order to the database using the repository
        return orderRepository.save(order);
    }
}
