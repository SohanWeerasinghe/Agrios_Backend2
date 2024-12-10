package com.example.Agrios_Product.repository;


import com.example.Agrios_Product.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional custom queries can be added here if needed
}