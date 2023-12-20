package com.bosonit.block7crud.repository;

import com.bosonit.block7crud.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
