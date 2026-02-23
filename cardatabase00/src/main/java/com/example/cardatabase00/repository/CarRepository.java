package com.example.cardatabase00.repository;

import com.example.cardatabase00.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
