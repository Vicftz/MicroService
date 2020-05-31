package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowingController {

	@Autowired
	private BorrowingRepository repository;
	@Autowired
	private BookRepository bookRepository;
	
	//Get a book by isbn
	@GetMapping("/borrowings/{id}")
	public Optional<Borrowing> getBorrowningById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	//Get all books
	@GetMapping("/borrowings")
	public List<Borrowing> getAllBorrowning() {
		return repository.findAll();
	}

	//Post
	@PostMapping("/borrowing")
	public Borrowing AddBorrowing(@RequestBody Borrowing borrowing) throws Exception {
		Long bookIsdn = borrowing.getIsbn();
		Book book = bookRepository.findByIsbn(bookIsdn);
		if(book.getAvailability()){
			book.setAvailability(false);
			bookRepository.saveAndFlush(book);
			return repository.saveAndFlush(borrowing);
		}else{
			return null;
		}
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ Exception.class })
	public void handleException(String message) {
	}

	
	//Update
	@PostMapping("/return/{id}")
	public Borrowing updateBook (@PathVariable Long id) {
		Borrowing borrowingToUpdate = repository.getOne(id);
		Book book = bookRepository.findByIsbn(borrowingToUpdate.getIsbn());
		borrowingToUpdate.setReturningDate((new SimpleDateFormat("dd-MM-yyyy")).format(new Date()));
		book.setAvailability(true);
		bookRepository.saveAndFlush(book);
		return repository.saveAndFlush(borrowingToUpdate);
	}
	
	
	
	//Delete
	@DeleteMapping("/borrowningDelete")
	public void deleteBorrowing (@RequestBody Borrowing borrowing) {
		repository.delete(borrowing);
	}

	
}
