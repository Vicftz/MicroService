package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReturningController {

	@Autowired
	private ReturningRepository repository;
	
	//Get a book by isbn
	@GetMapping("/returnings/{id}")
	public Optional<Returning> getReturningById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	//Get all books
	@GetMapping("/returnings")
	public List<Returning> getAllReturnings() {
		return repository.findAll();
	}

	//Post
	@PostMapping("/returnings")
	public Returning AddReturning(@RequestBody Returning returning) {
		return repository.saveAndFlush(returning);
	}

	
	//Update
	@PutMapping("/returningUpdates")
	public Returning updateReturning (@RequestBody Returning returning) {
		Returning returningToUpdate = repository.getOne(returning.getId());
		returningToUpdate.setIdReader(returning.getIdReader());
		returningToUpdate.setIsbn(returning.getIsbn());
		returningToUpdate.setReturningDate(returning.getReturningDate());
		return repository.saveAndFlush(returningToUpdate);
	}
	
	
	
	//Delete
		@DeleteMapping("/returningsDelete")
		public void deleteBook (@RequestBody Returning returning) {
			repository.delete(returning);
		}

	
}
