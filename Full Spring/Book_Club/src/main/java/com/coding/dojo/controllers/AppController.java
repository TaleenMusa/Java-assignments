package com.coding.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.dojo.models.Book;
import com.coding.dojo.models.LoginUser;
import com.coding.dojo.models.User;
import com.coding.dojo.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {

     @Autowired
     private BookService bookServ;
	 @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "login.jsp";
	    }
	 //Registration
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
		 bookServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/home";
	    }
	 
	 //Login
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = bookServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/books";
	    }
	 
	 //Logout
		@GetMapping("/logout")
	    public String logout(HttpSession session) {
			session.removeAttribute("user_id");
			return "redirect:/";
		}
	 
	 @GetMapping("/books")
	    public String home(Model model, HttpSession session) {
		 if (session.getAttribute("user_id") != null) {
	    	Long user_id = (Long) session.getAttribute("user_id");
	    	User thisUser = bookServ.findUserById(user_id);
	        model.addAttribute("thisUser", thisUser);
	        List<Book> allbooks=bookServ.allBooks();
	        model.addAttribute("allbooks", allbooks);
	        return "book.jsp";
	    }
		 else {
				return "redirect:/";
			}
}
	 //rendering new page to create a book
		@GetMapping("/books/new")
		public String addbook( @ModelAttribute("book") Book book) {
			return "createbook.jsp";
		}

		@PostMapping("/newbook")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	        	
	            return "createbook.jsp";
	        } else {
	        	bookServ.createBook(book);
	            return "redirect:/books/"+book.getId();
	        }
	    }
	 
		@GetMapping("/books/{id}")
	    public String viewBook(@PathVariable("id") Long id,Model model,HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Book book1 = bookServ.findBook(id);
				model.addAttribute("book1",book1);
				
				
				return "view.jsp";
			}
			else {
				return "redirect:/";
			}
	    }
		
}
