package com.logic.CRUDrepositories;

import com.logic.models.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel,Integer> {
    Fuel findAllByFuel(String fuel);
}
