package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Burger;
import com.example.demo.repositories.BurgerRepository;

@Service
public class BurgerService {
    // adding the burger repository as a dependency
    @Autowired
    private BurgerRepository burgerRepository;

    // returns all the burger
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    // creates a burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }

    // retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
	public void deleteBurger(Long id) {
		// TODO Auto-generated method stub
		 burgerRepository.deleteById(id);
		
	}
	public Burger updateBurger(Burger b) {
		// TODO Auto-generated method stub
		burgerRepository.save(b);
		return b;

	}
}
