package com.nikitaee.springwebapp.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dogs")
public class DogsController {

    @GetMapping("/beagle")
    public String showBeagle() {
        return "dogs/beagle";
    }

    @GetMapping("/labrador")
    public String showLabrador() {
        return "dogs/labrador";
    }
}
