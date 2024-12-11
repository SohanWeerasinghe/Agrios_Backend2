package com.example.Agrios_Product.controller;

import com.example.Agrios_Product.model.VegetablePrice;
import com.example.Agrios_Product.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/predict")
    public ResponseEntity<Double> predictVegetablePrice(@RequestParam String name) {
        double predictedPrice = vegetableService.predictPrice(name);
        return ResponseEntity.ok(predictedPrice);
    }
    @GetMapping("/price-trends")
    public List<VegetablePrice> getPriceTrends() {
        // Mock data or fetch from the database
        return List.of(
                // Carrot price trends
                new VegetablePrice("Carrot", 115, LocalDate.of(2023, 1, 1)),
                new VegetablePrice("Carrot", 180, LocalDate.of(2023, 2, 1)),
                new VegetablePrice("Carrot", 200, LocalDate.of(2023, 3, 1)),
                new VegetablePrice("Carrot", 270, LocalDate.of(2023, 4, 1)),

                // Tomato price trends
                new VegetablePrice("Tomato", 95, LocalDate.of(2023, 1, 1)),
                new VegetablePrice("Tomato", 170, LocalDate.of(2023, 2, 1)),
                new VegetablePrice("Tomato", 190, LocalDate.of(2023, 3, 1)),
                new VegetablePrice("Tomato", 160, LocalDate.of(2023, 4, 1)),

                // Potato price trends
                new VegetablePrice("Potato", 255, LocalDate.of(2023, 1, 1)),
                new VegetablePrice("Potato", 160, LocalDate.of(2023, 2, 1)),
                new VegetablePrice("Potato", 265, LocalDate.of(2023, 3, 1)),
                new VegetablePrice("Potato", 245, LocalDate.of(2023, 4, 1))
        );
    }

    @GetMapping("/price-comparison")
    public List<Map<String, Object>> getPriceComparison() {
        // Mock data or fetch from the database
        return List.of(
                Map.of("month", "Jan", "price", 120, "vegetable", "Carrot"),
                Map.of("month", "Feb", "price", 190, "vegetable", "Carrot"),
                Map.of("month", "Mar", "price", 150, "vegetable", "Carrot"),
                Map.of("month", "Apr", "price", 290, "vegetable", "Carrot"),

                // Price comparison for Tomato
                Map.of("month", "Jan", "price", 150, "vegetable", "Tomato"),
                Map.of("month", "Feb", "price", 220, "vegetable", "Tomato"),
                Map.of("month", "Mar", "price", 200, "vegetable", "Tomato"),
                Map.of("month", "Apr", "price", 290, "vegetable", "Tomato"),

                // Price comparison for Potato
                Map.of("month", "Jan", "price", 100, "vegetable", "Potato"),
                Map.of("month", "Feb", "price", 130, "vegetable", "Potato"),
                Map.of("month", "Mar", "price", 150, "vegetable", "Potato"),
                Map.of("month", "Apr", "price", 190, "vegetable", "Potato")
        );
    }
}
