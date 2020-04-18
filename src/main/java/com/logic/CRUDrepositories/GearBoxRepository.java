package com.logic.CRUDrepositories;

import com.logic.models.GearBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearBoxRepository extends JpaRepository<GearBox,Integer> {
    GearBox findAllByGearBox(String gear);
}
