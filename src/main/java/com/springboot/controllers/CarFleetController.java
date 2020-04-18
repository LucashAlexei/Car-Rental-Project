package com.springboot.controllers;

import com.logic.CRUDrepositories.*;
import com.logic.DTO.FilterDTO;
import com.logic.DTO.OrderDTO;
import com.logic.models.Customer;
import com.logic.models.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller
public class CarFleetController {
    private final CarsRepository carsRepository;
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final GearBoxRepository gearBoxRepository;
    private final BodyRepository bodyRepository;
    private final FuelRepository fuelRepository;
    private int carId;

    @GetMapping("/carfleet")
    public String getCarFleet(Model model, @RequestParam(defaultValue = "0")int page, Boolean filterSend){
        filterSend = false;
        model.addAttribute("filterFleet", filterSend);

        model.addAttribute("fleetList", carsRepository.findAll(PageRequest.of(page,3)));
        model.addAttribute("Body", bodyRepository.findAll());
        model.addAttribute("Gear", gearBoxRepository.findAll());
        model.addAttribute("Fuel", fuelRepository.findAll());
        model.addAttribute("filterDTO", new FilterDTO());
        return "carfleet";
    }

    //onCurrent info about car
    @GetMapping("/onCurrent/{id}")
    public String bla(Model model, @PathVariable Integer id){
        model.addAttribute("orderDTO", new OrderDTO());
        carId = carsRepository.findById(id).get().getCarId();
        model.addAttribute("cur" ,carsRepository.findById(id));
        model.addAttribute("locationList",employeeRepository.findAll());
        model.addAttribute(customerRepository.findAll());
        return "current";
    }

    @PostMapping(value = "/orderForm")
    public String order(@ModelAttribute("orderDTO")@Valid  OrderDTO orderDTO, BindingResult bindingResult, Model model,
                        @RequestParam(required = false) Boolean send) {
        send=true;
        model.addAttribute("sendBool", send);
        model.addAttribute("cur" ,carsRepository.findById(carId));

        int totalPrice = carsRepository.findById(carId).get().getPricePerDay() * Integer.parseInt(orderDTO.getRendTime());
        model.addAttribute("totalPrice", totalPrice);

        if(bindingResult.hasErrors()){
            return "current";
        }

        Orders order = new Orders();
        Customer customer = new Customer();

        customer.setCus_name(orderDTO.getCustomerName());
        customer.setPhone_number(orderDTO.getPhoneNumber());
        customer.setCard_num(orderDTO.getCardNumber());
        customerRepository.save(customer);

        order.setArend_time(orderDTO.getRendTime());
        order.setEmployee(orderDTO.getEmployee());

        order.setCustomer(customerRepository.findById(customer.getCus_id()).orElseThrow(NoSuchElementException::new));
        order.setCars(carsRepository.findById(carId).orElseThrow(NoSuchElementException::new));

        ordersRepository.save(order);
        return "current";
    }


}
