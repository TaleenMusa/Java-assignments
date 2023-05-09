package com.axsos.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.axsos.spring.models.Category;
import com.axsos.spring.models.Product;
import com.axsos.spring.services.AppService;

import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
        this.appService= appService;
    }
	
	@RequestMapping("/")
    public String index(Model model) {
		List<Product> allProducts=appService.allProducts();
      	 model.addAttribute("allproducts",allProducts);
      	 
      	List<Category> allCategories=appService.allCategories();
     	 model.addAttribute("allcategories",allCategories);
     	 
        return "index.jsp";
    }
	
	@RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "product.jsp";
    }
	
	@RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "category.jsp";
    }
	
	@RequestMapping("/newproduct")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
            if (result.hasErrors()) {
                return "product.jsp";
            }
            else {
                appService.createProduct(product);
                return "redirect:/";
            }
        }
	
	@RequestMapping("/newcategory")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
            if (result.hasErrors()) {
                return "category.jsp";
            }
            else {
                appService.createCategory(category);
                return "redirect:/";
            }
        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
