package com.logic.CRUDrepositories;

import com.logic.models.Fuel;
import org.springframework.data.repository.CrudRepository;

public interface FuelRepository extends CrudRepository<Fuel,Integer> {
    Fuel findAllByFuel(String fuel);
}
