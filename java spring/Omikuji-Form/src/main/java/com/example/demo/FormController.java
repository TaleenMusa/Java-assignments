package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class FormController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/send", method=RequestMethod.POST)

	public String send(
		@RequestParam(value="number") int number,
		@RequestParam(value="city") String city,
		@RequestParam(value="name") String name,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="living") String living,
		@RequestParam(value="message") String message,HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby",hobby);
		session.setAttribute("living", living);
		session.setAttribute("message", message);
		return"redirect:/omikuji/show";
	}
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
	
	
}
