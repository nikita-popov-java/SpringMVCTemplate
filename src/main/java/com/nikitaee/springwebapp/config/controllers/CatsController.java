package com.nikitaee.springwebapp.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cats")
public class CatsController {

    @GetMapping("/maineCoon")
    public String showBeagle() {
        return "cats/maineCoon";
    }

    @GetMapping("/persian")
    public String showLabrador() {
        return "cats/persian";
    }
}
