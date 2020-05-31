package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class BookController {

	@Autowired
	private BookRepository repository;
	
	//Get a book by isbn
	@GetMapping("/books/{isbn}")
	public Book getBookByIsbn(@PathVariable Long isbn) {
		return repository.findByIsbn(isbn);
	}
	
	//Get all books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	//Post
	@PostMapping("/books")
	public Book AddBook(@RequestBody Book book) {
		return repository.saveAndFlush(book);
	}

	
	//Update
	@PutMapping("/bookUpdates")
	public Book updateBook (@RequestBody Book book) {
		Book bookToUpdate = repository.findByIsbn(book.getIsbn());
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setAvailability(book.getAvailability());
		bookToUpdate.setAuthor(book.getAuthor());
		bookToUpdate.setType(book.getType());
		bookToUpdate.setYear(book.getYear());
		return repository.saveAndFlush(bookToUpdate);
	}
	
	
	
	//Delete
	@PostMapping("/booksDelete/{isbn}")
	public String deleteBook (@PathVariable Long isbn)
	{
		repository.delete(repository.findByIsbn(isbn));
		return "Livre supprimé avec succès";
	}

	
}
