package com.axsos.dojo.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.dojo.models.Dojo;
import com.axsos.dojo.models.Ninja;
import com.axsos.dojo.services.AppServices;

import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppServices appServices;
	public AppController(AppServices appServices) {
        this.appServices= appServices;
    }
	
	@RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojo.jsp";
    }
	
	@RequestMapping("/dojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "dojo.jsp";
        }
        else {
            appServices.createDojo(dojo);
            long dojoId=dojo.getId();
            return "redirect:/dojos/"+dojoId;
        }
	}
        
	@RequestMapping("/ninjas/new")
        public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
        	List<Dojo> allDojos=appServices.allDojos();
       	 model.addAttribute("alldojos",allDojos);
            return "ninja.jsp";
        }
	
	@RequestMapping("/ninja")
        public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
                if (result.hasErrors()) {
                    return "ninja.jsp";
                }
                else {
                    appServices.createNinja(ninja);
                    return "redirect:/ninjas/new";
                }
            }
                
	@RequestMapping("/dojos/{id}")
        	    public String viewDojo(@PathVariable("id") Long id,Model model) {
        		 Dojo dojo1 = appServices.findDojo(id);
        	     model.addAttribute("dojo",dojo1);
        	        return "data.jsp";
        	    }
    }