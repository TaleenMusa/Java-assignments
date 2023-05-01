package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {

	
	@SuppressWarnings("unchecked")
	@suppressWarnings("unchecked")
	@RequestMapping("/")
	public String index(
			HttpSession Session,
			@RequestParam(value="farm", required=false)String farm,
			@RequestParam(value="cave", required=false)String cave,
			@RequestParam(value="house", required=false)String house,
			@RequestParam(value="quest", required=false)String quest

			) {
		int gold = 0;
		ArrayList<String> activities = new ArrayList<String>();

		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d y h:mm a");
		if(Session.getAttribute("gold")==null){
		Session.setAttribute("gold", gold);
		Session.setAttribute("activities", activities);
		}
		else {
			gold = (int) Session.getAttribute("gold");
			activities = (ArrayList<String>)Session.getAttribute("activities");
	}
		if(farm != null) {
			int amount = new Random().nextInt(11)+10;
			gold+=amount;
			activities.add(0, "You entered a farm and earned "+amount+" gold. ("+ simpleFormat.format(new Date())+")");
			Session.setAttribute("activities", activities);
			Session.setAttribute("gold", gold);
			return "redirect:/";
		}

		if(cave != null) {
			int amount = new Random().nextInt(6)+5;
			gold+=amount;
			activities.add(0, "You entered a cave and earned "+amount+" gold. ("+ simpleFormat.format(new Date())+")");
			Session.setAttribute("activities", activities);
			Session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if(house != null) {
			int amount = new Random().nextInt(4)+2;
			gold+=amount;
			activities.add(0, "You entered a house and earned "+amount+" gold. ("+ simpleFormat.format(new Date())+")");
			Session.setAttribute("activities", activities);
			Session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if(quest != null) {
			int amount = new Random().nextInt(101)-50;
			gold+=amount;
			if(amount>=0) {
				activities.add(0, "You completed a quest and earned "+amount+" gold. ("+ simpleFormat.format(new Date())+")");
			}else {
				activities.add(0, "You failed a quest and lost "+(amount*-1)+" gold. ("+ simpleFormat.format(new Date())+")");
				}
			
			Session.setAttribute("activities", activities);
			Session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
				return "index.jsp";
	}
	@RequestMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}
}
