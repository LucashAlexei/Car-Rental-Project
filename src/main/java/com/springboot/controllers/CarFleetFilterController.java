package com.springboot.controllers;

import com.logic.CRUDrepositories.BodyRepository;
import com.logic.CRUDrepositories.CarsRepository;
import com.logic.CRUDrepositories.FuelRepository;
import com.logic.CRUDrepositories.GearBoxRepository;
import com.logic.DTO.FilterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CarFleetFilterController {
    private final CarsRepository carsRepository;
    private final BodyRepository bodyRepository;
    private final GearBoxRepository gearBoxRepository;
    private final FuelRepository fuelRepository;
    FilterDTO tmp;

    @GetMapping("/getPages")
    public String getPages( Model model, @RequestParam(defaultValue = "0")int page, Boolean sendFilter){
        sendFilter=true;
        model.addAttribute("filterFleet", sendFilter);
        model.addAttribute("filterDTO" , new FilterDTO());

        //all any
        if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList",carsRepository.findAll(PageRequest.of(page,3)));
        }
        //all fields with values asc
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //all fields with values desc
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear, fuel, equipment
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        // asc sort, gear, fuel, equipment
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        // desc sort, gear, fuel, equipment
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        // gear, fuel, equipment
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEquals(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, fuel, equipment
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //desc sort, fuel, equipment
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //fuel, equipment
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEquals(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, equipment
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEqualsOrderByPricePerDayAsc(
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //desc sort, equipment
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEqualsOrderByPricePerDayDesc(
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //equipment
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEquals(
                            tmp.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, body, fuel, equipment
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, fuel, equipment
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, fuel, equipment
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, gear, equipment
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, gear, equipment
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear, equipment
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, gear
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, gear
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, fuel
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, fuel
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //body, fuel
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, equipment
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, equipment
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, gear, fuel
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, gear, fuel
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //gear, fuel
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEquals(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        // body, equipment
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && !tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            tmp.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body
        else if(tmp.getSortingOrder().equals("ascending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body
        else if(tmp.getSortingOrder().equals("descending") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //body
        else if(tmp.getSortingOrder().equals("any") && !tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEquals(
                            bodyRepository.findAllByBody(tmp.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, gear
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, gear
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //gear
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && !tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEquals(
                            gearBoxRepository.findAllByGearBox(tmp.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, fuel
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsOrderByPricePerDayAsc(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, fuel
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsOrderByPricePerDayDesc(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //fuel
        else if(tmp.getSortingOrder().equals("any") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && !tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEquals(
                            fuelRepository.findAllByFuel(tmp.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //only asc sort
        else if(tmp.getSortingOrder().equals("ascending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByOrderByPricePerDayAsc(
                            PageRequest.of(page,3)
                    ));
        }
        //only desc sort
        else if(tmp.getSortingOrder().equals("descending") && tmp.getSortingBody().equals("any")
                && tmp.getSortingGear().equals("any") && tmp.getSortingFuel().equals("any")
                && tmp.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByOrderByPricePerDayDesc(
                            PageRequest.of(page,3)
                    ));
        }
        return "carfleet";
    }


    @PostMapping("/filter")
    public String getFilter(@ModelAttribute("filterDTO")FilterDTO filterDTO, Model model, @RequestParam(defaultValue = "0")int page, Boolean sendFilter){
        sendFilter=true;
        model.addAttribute("filterFleet", sendFilter);

        tmp = filterDTO;

        //all any
        if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList",carsRepository.findAll(PageRequest.of(page,3)));
        }
        //all fields with values asc
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //all fields with values desc
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndFuelEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        // asc sort, gear, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")){
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        // desc sort, gear, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        // gear, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsAndEquipmentEquals(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //desc sort, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //fuel, equipment
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsAndEquipmentEquals(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEqualsOrderByPricePerDayAsc(
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //desc sort, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEqualsOrderByPricePerDayDesc(
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //equipment
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByEquipmentEquals(
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page, 3)
                    ));
        }
        //asc sort, body, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, fuel, equipment
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, gear, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, gear, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear, equipment
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, gear
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, gear
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //body, gear
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndGearEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, fuel
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, fuel
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //body, fuel
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndFuelEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body, equipment
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body, equipment
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, gear, fuel
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, gear, fuel
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //gear, fuel
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsAndFuelEquals(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        // body, equipment
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && !filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsAndEquipmentEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            filterDTO.getSortingEquipment(),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, body
        else if(filterDTO.getSortingOrder().equals("ascending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsOrderByPricePerDayAsc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, body
        else if(filterDTO.getSortingOrder().equals("descending") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEqualsOrderByPricePerDayDesc(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //body
        else if(filterDTO.getSortingOrder().equals("any") && !filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByBodyEquals(
                            bodyRepository.findAllByBody(filterDTO.getSortingBody()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, gear
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsOrderByPricePerDayAsc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, gear
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEqualsOrderByPricePerDayDesc(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //gear
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && !filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByGearEquals(
                            gearBoxRepository.findAllByGearBox(filterDTO.getSortingGear()),
                            PageRequest.of(page,3)
                    ));
        }
        //asc sort, fuel
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsOrderByPricePerDayAsc(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //desc sort, fuel
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEqualsOrderByPricePerDayDesc(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //fuel
        else if(filterDTO.getSortingOrder().equals("any") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && !filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByFuelEquals(
                            fuelRepository.findAllByFuel(filterDTO.getSortingFuel()),
                            PageRequest.of(page,3)
                    ));
        }
        //only asc sort
        else if(filterDTO.getSortingOrder().equals("ascending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByOrderByPricePerDayAsc(
                            PageRequest.of(page,3)
                    ));
        }
        //only desc sort
        else if(filterDTO.getSortingOrder().equals("descending") && filterDTO.getSortingBody().equals("any")
                && filterDTO.getSortingGear().equals("any") && filterDTO.getSortingFuel().equals("any")
                && filterDTO.getSortingEquipment().equals("any")) {
            model.addAttribute("filterList", carsRepository.
                    findAllByOrderByPricePerDayDesc(
                            PageRequest.of(page,3)
                    ));
        }
        return "carfleet";
    }
}
