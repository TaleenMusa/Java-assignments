package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class HelloHuman{
     	@RequestMapping("/")
     	public String index(@RequestParam(value="FirstName", required=false)String firstName, @RequestParam(value="LastName", required=false)String lastName) {
     		if(firstName==null) {
     		return "<h1> Hello Human <h1>";
     	}
     		else {
	        	return "Hello: " + firstName + "      " + lastName;    	
	        }
     	}
	
}
