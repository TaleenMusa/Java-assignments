package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Expense;
import com.coding.dojo.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
	
	
	public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // createExpense
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves 
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
		
	}
	public Expense updateExpense(Expense b) {
		// TODO Auto-generated method stub
		expenseRepository.save(b);
		return b;

	}
	
	
}