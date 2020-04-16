package com.logic.CRUDrepositories;

import com.logic.models.GearBox;
import org.springframework.data.repository.CrudRepository;

public interface GearBoxRepository extends CrudRepository<GearBox,Integer> {
    GearBox findAllByGearBox(String gear);
}
