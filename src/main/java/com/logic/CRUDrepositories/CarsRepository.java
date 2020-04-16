package com.logic.CRUDrepositories;

import com.logic.models.Body;
import com.logic.models.Cars;
import com.logic.models.Fuel;
import com.logic.models.GearBox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarsRepository extends CrudRepository<Cars,Integer>, PagingAndSortingRepository<Cars,Integer> {//, PagingAndSortingRepository<Cars,Integer>

    Page<Cars> findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEquals(Body body, GearBox gearBox, Fuel fuel, String equipment, Pageable page);

    Page<Cars> findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(Body body, GearBox gearBox, Fuel fuel, String equipment, Pageable page);
    Page<Cars> findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(Body body, GearBox gearBox, Fuel fuel, String equipment, Pageable page);

    //-------//
//    Page<Cars> findAllByGearEqualsAndBodyEqualsAndEquipmentEqualsOrderByPricePerDayAsc(GearBox gearBox, Body body, String equipment, Pageable page);
//    Page<Cars> findAllByGearEqualsAndBodyEqualsAndEquipmentEqualsOrderByPricePerDayDesc(GearBox gearBox, Body body, String equipment, Pageable page);

    Page<Cars> findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(GearBox gearBox, Fuel fuel, String equipment, Pageable page);
    Page<Cars> findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(GearBox gearBox, Fuel fuel, String equipment, Pageable page);

    Page<Cars> findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(Body body, Fuel fuel, String equipment, Pageable page);
//    Page<Cars> findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(Body body, Fuel fuel, String equipment, Pageable page);
//
//    Page<Cars> findAllByGearEqualsAndFuelEqualsAndBodyEqualsOrderByPricePerDayAsc( GearBox gearBox, Fuel fuel, Body body, Pageable page);
//    Page<Cars> findAllByGearEqualsAndFuelEqualsAndBodyEqualsOrderByPricePerDayDesc( GearBox gearBox, Fuel fuel, Body body, Pageable page);
    //---//

   // Page<Cars> findAllByGearEqualsAndBodyEqualsAndEquipmentEquals(GearBox gearBox, Body body, String equipment, Pageable page);

    Page<Cars> findAllByGearEqualsAndFuelEqualsAndEquipmentEquals(GearBox gearBox, Fuel fuel, String equipment, Pageable page);

  //  Page<Cars> findAllByGearEqualsAndFuelEqualsAndBodyEquals( GearBox gearBox, Fuel fuel, Body body, Pageable page);

    Page<Cars> findAllByBodyEqualsAndFuelEqualsAndEquipmentEquals(Body body, Fuel fuel, String equipment, Pageable page);


    //-------//
    Page<Cars> findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(Fuel fuel, String equipment, Pageable page);
    Page<Cars> findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(Fuel fuel, String equipment, Pageable page);

    Page<Cars> findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayAsc(Body body, String equipment, Pageable page);
    Page<Cars> findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayDesc(Body body, String equipment, Pageable page);

//    Page<Cars> findAllByGearEqualsAndEquipmentEqualsOrderByPricePerDayAsc(GearBox gear, String equipment, Pageable page);
//    Page<Cars> findAllByGearEqualsAndEquipmentEqualsOrderByPricePerDayDesc(GearBox gear, String equipment, Pageable page);
//
//    Page<Cars> findAllByGearEqualsAndBodyEqualsOrderByPricePerDayAsc(GearBox gear, Body body, Pageable page);
//    Page<Cars> findAllByGearEqualsAndBodyEqualsOrderByPricePerDayDesc(GearBox gear, Body body, Pageable page);
//
//    Page<Cars> findAllByFuelEqualsAndBodyEqualsOrderByPricePerDayAsc(Fuel fuel, Body body, Pageable page);
//    Page<Cars> findAllByFuelEqualsAndBodyEqualsOrderByPricePerDayDesc(Fuel fuel, Body body, Pageable page);
//
//    Page<Cars> findAllByFuelEqualsAndGearEqualsOrderByPricePerDayAsc(Fuel fuel, GearBox gear, Pageable page);
//    Page<Cars> findAllByFuelEqualsAndGearEqualsOrderByPricePerDayDesc(Fuel fuel, GearBox gear, Pageable page);
    //----//

    Page<Cars> findAllByFuelEqualsAndEquipmentEquals(Fuel fuel, String equipment, Pageable page);
    Page<Cars> findAllByBodyEqualsAndEquipmentEquals(Body body, String equipment, Pageable page);
//    Page<Cars> findAllByGearEqualsAndEquipmentEquals(GearBox gear, String equipment, Pageable page);
//    Page<Cars> findAllByGearEqualsAndBodyEquals(GearBox gear, Body body, Pageable page);
//    Page<Cars> findAllByFuelEqualsAndBodyEquals(Fuel fuel, Body body, Pageable page);
//    Page<Cars> findAllByFuelEqualsAndGearEquals(Fuel fuel, GearBox gear, Pageable page);
    //------//

    Page<Cars> findAllByEquipmentEqualsOrderByPricePerDayAsc(String equipment, Pageable page);
    Page<Cars> findAllByEquipmentEqualsOrderByPricePerDayDesc(String equipment, Pageable page);

    Page<Cars> findAllByBodyEqualsOrderByPricePerDayAsc(Body body, Pageable page);
    Page<Cars> findAllByBodyEqualsOrderByPricePerDayDesc(Body body, Pageable page);

    Page<Cars> findAllByFuelEqualsOrderByPricePerDayAsc(Fuel fuel, Pageable page);
    Page<Cars> findAllByFuelEqualsOrderByPricePerDayDesc(Fuel fuel, Pageable page);

    Page<Cars> findAllByGearEqualsOrderByPricePerDayAsc(GearBox gear, Pageable page);
    Page<Cars> findAllByGearEqualsOrderByPricePerDayDesc(GearBox gear, Pageable page);

    //-----//
    Page<Cars> findAllByEquipmentEquals(String equipment, Pageable page);
    Page<Cars> findAllByBodyEquals(Body body, Pageable page);
    Page<Cars> findAllByFuelEquals(Fuel fuel, Pageable page);
    Page<Cars> findAllByGearEquals(GearBox gear, Pageable page);

    Page<Cars> findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayAsc(Body body, GearBox gear, String sortingEquipment, Pageable page);
    Page<Cars> findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayDesc(Body body, GearBox gear, String sortingEquipment,Pageable page);
    Page<Cars> findAllByBodyEqualsAndGearEqualsAndEquipmentEquals(Body body, GearBox gear, String sortingEquipment, Pageable page);

    Page<Cars> findAllByBodyEqualsAndGearEqualsOrderByPricePerDayAsc(Body body, GearBox gear, Pageable page);
    Page<Cars> findAllByBodyEqualsAndGearEqualsOrderByPricePerDayDesc(Body body, GearBox gear, Pageable page);
    Page<Cars> findAllByBodyEqualsAndGearEquals(Body body, GearBox gear, Pageable page);

    Page<Cars> findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayAsc(Body body, Fuel fuel, Pageable page);
    Page<Cars> findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayDesc(Body body, Fuel fuel, Pageable page);
    Page<Cars> findAllByBodyEqualsAndFuelEquals(Body body, Fuel fuel, Pageable page);

    Page<Cars> findAllByGearEqualsAndFuelEqualsOrderByPricePerDayAsc(GearBox gear, Fuel fuel, Pageable page);
    Page<Cars> findAllByGearEqualsAndFuelEqualsOrderByPricePerDayDesc(GearBox gear, Fuel fuel, Pageable page);
    Page<Cars> findAllByGearEqualsAndFuelEquals(GearBox gear, Fuel fuel, Pageable page);

    Page<Cars> findAllByOrderByPricePerDayAsc(Pageable page);
    Page<Cars> findAllByOrderByPricePerDayDesc(Pageable page);
}