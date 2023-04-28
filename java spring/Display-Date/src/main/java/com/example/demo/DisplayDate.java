package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DisplayDate {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
    @RequestMapping("/date")
    public String date(Model model) {
 
		SimpleDateFormat Dateinfo = new SimpleDateFormat("EEEE, MMMM d , yyyy");
	   	
		Date date=new Date(); 

		model.addAttribute("date",Dateinfo.format(date));
    	return "Date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	SimpleDateFormat Tomeinfo = new SimpleDateFormat("h:mm a");
	   	
		Date time=new Date(); 

		model.addAttribute("time",Tomeinfo.format(time));
    	return "time.jsp";
    }
}
