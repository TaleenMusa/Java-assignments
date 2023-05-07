package com.axsos.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.axsos.dojo.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{
// this method retrieves all from the database
List<Ninja> findAll();
}