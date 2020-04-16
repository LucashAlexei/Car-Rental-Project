package com.springboot.controllers;

import com.logic.CRUDrepositories.BodyRepository;
import com.logic.CRUDrepositories.CarsRepository;
import com.logic.CRUDrepositories.FuelRepository;
import com.logic.CRUDrepositories.GearBoxRepository;
import com.logic.DTO.AdminDTO;
import com.logic.models.Cars;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final CarsRepository carsRepository;
    private final BodyRepository bodyRepository;
    private final GearBoxRepository gearBoxRepository;
    private final FuelRepository fuelRepository;

    @GetMapping(value = "/admin")
    public String adminForm(Model model){
        model.addAttribute("object", new AdminDTO());
        model.addAttribute("bodyList", bodyRepository.findAll());
        model.addAttribute("gearBoxList", gearBoxRepository.findAll());
        model.addAttribute("fuelList", fuelRepository.findAll());
        return "admin";
    }

    @PostMapping(value = "adminFrom")
    public String addCarForm(@ModelAttribute(name="object") AdminDTO object){
        Cars car = new Cars();

        car.setCar_model(object.getCarModel());
        car.setEquipment(object.getEquipment());
        car.setPricePerDay(object.getPricePerDay());
        car.setYear(object.getYear());
        car.setBody(object.getBody());
        car.setGear(object.getGearBox());
        car.setFuel(object.getFuel());

        carsRepository.save(car);

        return "index";
    }
}
