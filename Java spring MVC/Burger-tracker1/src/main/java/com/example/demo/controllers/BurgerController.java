package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import com.example.demo.models.Burger;
import com.example.demo.services.BurgerService;

@Controller
public class BurgerController {
    @Autowired
    private BurgerService burgerService;

    @GetMapping("/")
    public String newBurger(@ModelAttribute("burger") Burger burger,Model model) {
    	List<Burger> allburgers=burgerService.allBurgers();
		 	model.addAttribute("allBurgers",allburgers);
    	return "index.jsp";
    }

    @PostMapping("/burger")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Burger> allburgers=burgerService.allBurgers();
   		 	model.addAttribute("allBurgers",allburgers);
            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
            burgerService.allBurgers();
            return "redirect:/burger";
        }
    }
}
