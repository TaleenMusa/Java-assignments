package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Burger;
import com.example.demo.services.BurgerService;

import jakarta.validation.Valid;

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

    @PostMapping("/")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {

            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
            return "redirect:/";
        }
    }
    @RequestMapping("/burger/{id}/edit")
    public String edit(@PathVariable("id") Long id,Model model) {
	     Burger burger1 = burgerService.findBurger(id);
	     model.addAttribute("burger",burger1);
	     return "edit.jsp";
    }
    
    @RequestMapping(value="/handle/{id}",method=RequestMethod.PUT)
    public String editing(@Valid @ModelAttribute("burger") Burger burger,BindingResult result,Model model) {
    	if (result.hasErrors()) {
		     model.addAttribute("burger",burger);
		     return "edit.jsp";
        } else {
        	burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }
    
}
