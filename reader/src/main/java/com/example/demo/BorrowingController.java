package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowingController {

    @Autowired
    private BorrowingRepository repository;

    @GetMapping("/borrowings/{id}")
    public Optional<Borrowing> getBorrowningById(@PathVariable Long id)
    {
        return repository.findById(id);
    }
    
	@GetMapping("/borrowings")
	public List<Borrowing> getAllBorrowings() {
		return repository.findAll();
	}
}
