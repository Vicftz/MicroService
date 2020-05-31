package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiBookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/books/{isbn}")
	public Book getBookByIsbn(@PathVariable Long isbn) {
		return repository.findByIsbn(isbn);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@PostMapping("/books")
	public Book AddBook(@RequestBody Book book) {
		return repository.saveAndFlush(book);
	}

}
