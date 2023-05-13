package com.coding.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.dojo.services.AppService;

@Controller
public class AppController {
	@Autowired
	private AppService appService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> sloveneSpeakingCountries = appService.sloveneSpeakingCountries();
		model.addAttribute("sloveneSpeakingCountries", sloveneSpeakingCountries);
		
		List<Object[]> citiesPerCountry = appService.citiesPerCountry();
		model.addAttribute("citiesPerCountry", citiesPerCountry);
		
		List<Object[]> mexicanCityPop = appService.mexicanCityPop();
		model.addAttribute("mexicanCityPop", mexicanCityPop);
		
		List<Object[]> countryLanguages = appService.countryLanguages();
		model.addAttribute("countryLanguages", countryLanguages);
		
		List<Object[]> countrySurfaceArea = appService.countrySurfaceArea();
		model.addAttribute("countrySurfaceArea", countrySurfaceArea);
		
		List<Object[]> constitutionalMonarchies = appService.constitutionalMonarchies();
		model.addAttribute("constitutionalMonarchies", constitutionalMonarchies);
		
		List<Object[]> argentinaCities = appService.argentinaCities();
		model.addAttribute("argentinaCities", argentinaCities);
		
		List<Object[]> countriesPerRegion = appService.countriesPerRegion();
		model.addAttribute("countriesPerRegion", countriesPerRegion);
		
		return "index.jsp";
	}
}
