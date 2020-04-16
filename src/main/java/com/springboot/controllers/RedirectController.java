package com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/onIndex")
    public String onIndex() {
        return "redirect:/index";
    }
    @GetMapping("/onConditions")
    public String onConditions() {
        return "redirect:/conditions";
    }
    @GetMapping("/onContacts")
    public String onContacts() {
        return "redirect:/contacts";
    }
    @GetMapping("/onCarfleet")
    public String onCarfleet() {
        return "redirect:/carfleet";
    }
    @GetMapping("/onMaintenance")
    public String onMaintenance() {
        return "redirect:/maintenance";
    }
    @GetMapping("/onLeasing")
    public String onLeasing() {
        return "redirect:/leasing";
    }
}
