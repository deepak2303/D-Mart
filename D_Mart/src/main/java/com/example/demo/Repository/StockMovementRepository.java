package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.StockMovement;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

}
