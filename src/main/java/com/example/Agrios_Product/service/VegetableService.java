package com.example.Agrios_Product.service;

import com.example.Agrios_Product.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public double predictPrice(String vegetableName) {
        List<Double> prices = vegetableRepository.findPricesByVegetableName(vegetableName);
        if (prices.isEmpty()) return 0.0; // Handle no data case

        // Simple average prediction
        double total = prices.stream().mapToDouble(Double::doubleValue).sum();
        return total / prices.size();
    }
}

