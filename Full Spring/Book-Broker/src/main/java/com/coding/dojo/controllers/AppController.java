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
    private AppService appServ;
	
	@GetMapping("/")
    public String index(Model model) {
		
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
		appServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = appServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
	
	@GetMapping("/books")
    public String home(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        List<Book> allbooks=appServ.allBooks();
        model.addAttribute("allbooks", allbooks);
        return "book.jsp";
        }
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	@GetMapping("/books/new")
	public String newBook( @ModelAttribute("book") Book book) {
		return "createbook.jsp";
	}
	
	@PostMapping("/newbook")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	
            return "createbook.jsp";
        } else {
        	appServ.createBook(book);
            return "redirect:/books/"+book.getId();
        }
    }
	
	@GetMapping("/books/{id}")
    public String viewBook(@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book1 = appServ.findBook(id);
			model.addAttribute("book1",book1);
			
			
			return "view.jsp";
		}
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/bookmarket")
    public String bookMarket(Model model,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long user_id=(Long) session.getAttribute("user_id");
			User user1=appServ.findUserById(user_id);
			model.addAttribute("user1",user1);
			List<Book> allbooks=appServ.findAvailableBooks();
			model.addAttribute("allbooks",allbooks);
			return "book.jsp";
		}
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book1 = appServ.findBook(id);
			Long user_id=(Long) session.getAttribute("user_id");
			User user1=appServ.findUserById(user_id);
			book1.setBorrower(user1);
			appServ.updateBook(book1);
			return "redirect:/bookmarket";
		}
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book1 = appServ.findBook(id);
			Long user_id=(Long) session.getAttribute("user_id");
			User user1=appServ.findUserById(user_id);
			book1.setBorrower(null);
			appServ.updateBook(book1);
			user1.getBorrowedBooks().remove(book1);
			appServ.updateUser(user1);
			return "redirect:/bookmarket";
		}
		else {
			return "redirect:/";
		}
    }
	
	@GetMapping("/edit/{id}")
    public String editBook(@ModelAttribute("book") Book book,@PathVariable("id") Long id,Model model) {
		Book book1 = appServ.findBook(id);
			model.addAttribute("book", book1);
			return "edit.jsp";
		
    }
	
	@PutMapping("/handle/{id}")
	public String edit(@Valid @ModelAttribute("book") Book book,BindingResult result,Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("book", book);
				return "edit.jsp";
        }
    	else {
        	book=appServ.updateBook(book);
            return "redirect:/bookmarket";
        }
    }
	
	 @GetMapping("/delete/{id}")
	    public String deleteBook(@PathVariable("id") Long id) {
		 appServ.deleteBook(id);
				return "redirect:/bookmarket";
	    }
}