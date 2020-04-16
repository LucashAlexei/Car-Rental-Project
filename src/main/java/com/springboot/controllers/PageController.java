package com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

//    @GetMapping("/carfleet")
//    public String getCarFleet(){
//        return "carfleet";
//    }

    @GetMapping("/conditions")
    public String getConditions(){
        return "conditions";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/leasing")
    public String getLeasing(){
        return "leasing";
    }

    @GetMapping("/current")
    public String getCurrent(){
        return "current";
    }

    @GetMapping("/maintenance")
    public String getMaintenance(){
        return "maintenance";
    }

//    @GetMapping("/admin")
//    public String getAdmin(){
//        return "admin";
//    }
}
