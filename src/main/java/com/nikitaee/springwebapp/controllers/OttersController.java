package com.nikitaee.springwebapp.controllers;

import com.nikitaee.springwebapp.dao.OtterDAO;
import com.nikitaee.springwebapp.models.Otter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        return "otters/index";
    }

    @PostMapping()
    public String create(@ModelAttribute("otter") Otter otter) {

        otterDAO.save(otter);

        return "redirect:/otters"; //address in browser
    }

    @GetMapping("/{type}")
    public String index(@PathVariable("type") String type, Model model) {

        model.addAttribute("otterType", otterDAO.show(type));

        return "otters/show";
    }

    @PutMapping("/{type}")
    public String update(@PathVariable("type") String type,
                         @ModelAttribute("otter") @Valid Otter otter,
                         BindingResult result) {

        if (result.hasErrors())
            return "otters/edit";

        otterDAO.update(type, otter);

        return "redirect:/otters";
    }

    @DeleteMapping("/{type}")
    public String delete(@PathVariable("type") String type) {

        otterDAO.delete(type);

        return "redirect:/otters";
    }

    @GetMapping("/new") //ModelAttribute for automatically injecting Otter object into form
    public String newOtter(@ModelAttribute("otter") Otter otter) {

        return "otters/new";
    }

    @GetMapping("/{type}/edit")
    public String edit(@PathVariable("type") String type, Model model) {

        model.addAttribute("otter", otterDAO.show(type));

        return "otters/edit";
    }
}
