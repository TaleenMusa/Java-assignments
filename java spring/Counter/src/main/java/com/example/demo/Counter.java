package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Counter {

	@RequestMapping("/")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		else {
			session.setAttribute("count",(Integer)session.getAttribute("count")+1);
		}
		return"count.jsp";
}
}