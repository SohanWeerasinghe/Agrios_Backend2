package com.example.Agrios_Product.service;


import com.example.Agrios_Product.model.Message;
import com.example.Agrios_Product.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);  // Save the message in the database
    }

    // Get all messages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}
