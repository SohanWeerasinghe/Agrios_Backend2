package com.example.Agrios_Product.repository;


import com.example.Agrios_Product.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Additional query methods can be added here if needed
}