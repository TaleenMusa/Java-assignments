package com.axsos.spring.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.axsos.spring.models.Category;
import com.axsos.spring.models.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category c);
}
