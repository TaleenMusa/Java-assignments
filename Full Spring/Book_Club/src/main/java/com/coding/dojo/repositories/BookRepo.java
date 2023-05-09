package com.coding.dojo.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
// this method retrieves all from the database
	List<Book> findAll();
}
