package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturningController {

    @Autowired
    private ReturningRepository repository;

    @GetMapping("/returnings/{id}")
    public Optional<Returning> getBorrowningById(@PathVariable Long id)
    {
        return repository.findById(id);
    }
    
	@GetMapping("/returnings")
	public List<Returning> getAllBorrowings() {
		return repository.findAll();
	}
	
	
}

