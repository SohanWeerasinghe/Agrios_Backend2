package com.example.Agrios_Product.repository;

import com.example.Agrios_Product.model.VegetablePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegetableRepository extends JpaRepository<VegetablePrice, Long> {
    @Query("SELECT v.price FROM VegetablePrice v WHERE v.name = :name")
    List<Double> findPricesByVegetableName(@Param("name") String name);
}
