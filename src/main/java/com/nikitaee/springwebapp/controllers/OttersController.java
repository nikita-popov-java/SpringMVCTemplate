package com.nikitaee.springwebapp.controllers;

import com.nikitaee.springwebapp.dao.OtterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/otters")
public class OttersController {
    private final OtterDAO otterDAO;

    @Autowired
    public OttersController(OtterDAO otterDAO) {
        this.otterDAO = otterDAO;
    }

    @GetMapping()
    public String index(Model model) {

        model.addAttribute("otters", otterDAO.index());
        System.out.println(otterDAO.index());
        return "otters/index";
    }

    @GetMapping("/{type}")
    public String index(@PathVariable("type") String type, Model model) {

        model.addAttribute("otterType", otterDAO.show(type));

        System.out.println(otterDAO.show(type));
        return "otters/show";
    }
}
