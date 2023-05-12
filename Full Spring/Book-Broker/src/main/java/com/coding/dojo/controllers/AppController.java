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
import org.springframework.web.bind.annotation.PutMapping;

import com.coding.dojo.models.Book;
import com.coding.dojo.models.LoginUser;
import com.coding.dojo.models.User;
import com.coding.dojo.services.AppService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {

     @Autowired
     private AppService appService;
     
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
		 appService.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/books";
	    }
	 
	 //Login
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = appService.login(newLogin, result);
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
	    	User thisUser = appService.findUserById(user_id);
	        model.addAttribute("thisUser", thisUser);
	        List<Book> allbooks=appService.allBooks();
	        model.addAttribute("allbooks", allbooks);
	        return "book.jsp";
	    }
		 else {
				return "redirect:/";
			}
}
	 //rendering new page to create a book
		@GetMapping("/books/new")
		public String addbook( @ModelAttribute("book") Book book, Model model, HttpSession session) {
	    	
	    	User user = appService.findUserById((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
			return "createbook.jsp";
		}

		@PostMapping("/newbook")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "createbook.jsp";
	        } else {
	        	appService.createBook(book);
	            return "redirect:/books/"+book.getId();
	        }
	    }
	 
		@GetMapping("/books/{id}")
	    public String viewBook(@PathVariable("id") Long id,Model model,HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Book book1 = appService.findBook(id);
				model.addAttribute("book1",book1);
				return "view.jsp";
			}
			else {
				return "redirect:/";
			}
	    }
		
		
		@GetMapping("/borrow/{id}")
	    public String borrowBook(@PathVariable("id") Long id,Model model,HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Book book1 = appService.findBook(id);
				Long user_id=(Long) session.getAttribute("user_id");
				User user1=appService.findUserById(user_id);
				book1.setBorrower(user1);
				appService.updateBook(book1);
				return "redirect:/books";
			}
			else {
				return "redirect:/";
			}
	    }
		
		@GetMapping("/return/{id}")
	    public String returnBook(@PathVariable("id") Long id,Model model,HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Book book1 = appService.findBook(id);
				Long user_id=(Long) session.getAttribute("user_id");
				User user1=appService.findUserById(user_id);
				book1.setBorrower(null);
				appService.updateBook(book1);
				user1.getBorrowedBooks().remove(book1);
				appService.updateUser(user1);
				return "redirect:/books";
			}
			else {
				return "redirect:/";
			}
	    }
		
		@GetMapping("/edit/{id}")
		public String editBook(@PathVariable("id") Long id, Model model ,HttpSession session) {
	    	if(session.getAttribute("userId") == null) {
	    		return "redirect:/";
	    	}
		    Book book1 = appService.findBook(id);
		    model.addAttribute("book", book1);
		    model.addAttribute("user", appService.findUserById((Long)session.getAttribute("userId")));
		    model.addAttribute("thisBook", book1);
		    return "edit.jsp";
		}

		@PutMapping("/handle/{id}")
		public String handleEdit(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book,
		                         BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        model.addAttribute("book", book);
		        return "edit.jsp";
		    } else {
		        book.setId(id); // Set the book ID to match the path variable
		        appService.updateBook(book);
		        return "redirect:/books";
		    }
		}

		
		 @GetMapping("/delete/{id}")
		    public String deleteBook(@PathVariable("id") Long id) {
			 appService.deleteBook(id);
					return "redirect:/books";
		    }
	}
