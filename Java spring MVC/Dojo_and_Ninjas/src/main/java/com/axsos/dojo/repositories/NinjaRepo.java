package com.axsos.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.axsos.dojo.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{
// this method retrieves all the ninja from the database
List<Ninja> findAll();
//// this method finds books with descriptions containing the search string
//List<Book> findByDescriptionContaining(String search);
//// this method counts how many titles contain a certain string
//Long countByTitleContaining(String search);
//// this method deletes a book that starts with a specific title
//Long deleteByTitleStartingWith(String search);
}