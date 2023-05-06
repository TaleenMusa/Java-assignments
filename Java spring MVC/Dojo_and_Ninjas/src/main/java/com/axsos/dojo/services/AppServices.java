package com.axsos.dojo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojo.models.Dojo;
import com.axsos.dojo.models.Ninja;
import com.axsos.dojo.repositories.DojoRepo;
import com.axsos.dojo.repositories.NinjaRepo;

@Service
public class AppServices {
 // adding the dojo repository as a dependency
	 private final DojoRepo dojoRepo;
	 private final NinjaRepo ninjaRepo;

 public AppServices(DojoRepo dojoRepo,NinjaRepo ninjaRepo) {
     this.dojoRepo = dojoRepo;
     this.ninjaRepo = ninjaRepo;
 }
 // returns all the dojos
 public List<Dojo> allDojos() {
     return dojoRepo.findAll();
 }
 // creates a dojo
 public Dojo createDojo(Dojo b) {
     return dojoRepo.save(b);
 }
 // retrieves a dojo
 public Dojo findDojo(Long id) {
     Optional<Dojo> optionalDojo = dojoRepo.findById(id);
     if(optionalDojo.isPresent()) {
         return optionalDojo.get();
     } else {
         return null;
     }
 }
 
 
 // returns all the ninjas
 public List<Ninja> allNinjas() {
     return ninjaRepo.findAll();
 }
 // creates a Ninja
 public Ninja createNinja(Ninja c) {
     return ninjaRepo.save(c);
 }
 // retrieves a Ninja
 public Ninja findNinja(Long id) {
     Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
     if(optionalNinja.isPresent()) {
         return optionalNinja.get();
     } else {
         return null;
     }
 }
}

