package com.axsos.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojo.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{
// this method retrieves all from the database
List<Dojo> findAll();
}