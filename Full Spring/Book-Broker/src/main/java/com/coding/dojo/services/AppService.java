package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.coding.dojo.models.Book;
import com.coding.dojo.models.LoginUser;
import com.coding.dojo.models.User;
import com.coding.dojo.repositories.BookRepo;
import com.coding.dojo.repositories.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class AppService {
		@Autowired
	    private UserRepo userRepo;
		
		@Autowired
	    private BookRepo bookRepo;
		
		@PersistenceContext
	    private EntityManager entityManager;

		
		public List<Book> allBooks() {
	        return bookRepo.findAll();
	    }
		
		public Book createBook(Book b) {
	        return bookRepo.save(b);
	    }
		
		public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepo.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
		public Book updateBook(Book b) {
			bookRepo.save(b);
			return b;
		}
		
		public void deleteBook(Long id) {
			bookRepo.deleteById(id);
		}
		
		//login and register methods
		public User updateUser(User b) {
			// TODO Auto-generated method stub
			userRepo.save(b);
			return b;

		}
		
		public User register(User newUser, BindingResult result) {
	        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
	            result.rejectValue("email", "Unique", "This email is already in use!");
	        }
	        if(!newUser.getPassword().equals(newUser.getConfirm())) {
	            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	            newUser.setPassword(hashed);
	            return userRepo.save(newUser);
	        }
	    }
		
		

		public User login(LoginUser newLogin, BindingResult result) {
	        if(result.hasErrors()) {
	            return null;
	        }
	        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	        if(!potentialUser.isPresent()) {
	            result.rejectValue("email", "Unique", "Unknown email!");
	            return null;
	        }
	        User user = potentialUser.get();
	        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            return user;
	        }
	    }
	    
	    
		
	    public User findUserById(Long id) {
	    	Optional<User> u = userRepo.findById(id);

	    	if(u.isPresent()) {
				return u.get();
				} else {
				return null;
	    	}
		}

	    public List<Book> findAvailableBooks() {
		    String jpql = "SELECT b FROM Book b WHERE b.borrower IS NULL";
		    TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
		    return query.getResultList();
		}
	}