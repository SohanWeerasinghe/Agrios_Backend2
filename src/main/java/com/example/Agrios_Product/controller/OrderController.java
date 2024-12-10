package com.example.Agrios_Product.controller;




import com.example.Agrios_Product.model.Order;
import com.example.Agrios_Product.model.OrderDTO;
import com.example.Agrios_Product.repository.OrderRepository;
import com.example.Agrios_Product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend communication
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;


    // Get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order order = new Order();
            order.setProductId(orderDTO.getProductId());  // Getting productId from OrderDTO
            order.setAddress(orderDTO.getDeliveryAddress());  // Setting delivery address
            orderRepository.save(order);  // Save to the database
            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // If you need another method, change the path to avoid the conflict
    @PostMapping("/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO orderDTO) {
        try {
            // Create a new Order entity
            Order order = new Order();
            order.setProductId(orderDTO.getProductId());
            order.setAddress(orderDTO.getDeliveryAddress());
            order.setQuantity(orderDTO.getQuantity());  // Set quantity
            order.setProductName(orderDTO.getProductName());  // Set product name
            order.setTotalAmount(orderDTO.getTotalAmount());  // Set total amount
            order.setOrderDate(LocalDateTime.now());  // Set current timestamp

            // Save the order to the database
            orderRepository.save(order);

            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

