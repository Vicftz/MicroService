package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowingController {

	@Autowired
	private BorrowingRepository repository;
	
	//Get a book by isbn
	@GetMapping("/borrownings/{id}")
	public Optional<Borrowing> getBorrowningById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	//Get all books
	@GetMapping("/borrownings")
	public List<Borrowing> getAllBorrowning() {
		return repository.findAll();
	}

	//Post
	@PostMapping("/borrownings")
	public Borrowing AddBorrowing(@RequestBody Borrowing borrowing) {
		return repository.saveAndFlush(borrowing);
	}

	
	//Update
	@PutMapping("/borrowningUpdates")
	public Borrowing updateBook (@RequestBody Borrowing borrowing) {
		Borrowing borrowingToUpdate = repository.getOne(borrowing.getId());
		borrowingToUpdate.setIsbn(borrowing.getIsbn());
		borrowingToUpdate.setIdReader(borrowing.getIdReader());
		borrowingToUpdate.setBorrowingDate(borrowing.getBorrowingDate());
		borrowingToUpdate.setReturningDate(borrowing.getReturningDate());
		return repository.saveAndFlush(borrowingToUpdate);
	}
	
	
	
	//Delete
		@DeleteMapping("/borrowningDelete")
		public void deleteBorrowing (@RequestBody Borrowing borrowing) {
			repository.delete(borrowing);
		}

	
}
