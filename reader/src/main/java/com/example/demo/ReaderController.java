package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ReaderController {

	@Autowired
	private ReaderRepository repository;
	
	//Get a reader by isbn
	@GetMapping("/readers/{id}")
	public Optional<Reader> getReaderById(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	//Get all readers
	@GetMapping("/readers")
	public List<Reader> getAllReaders() {
		return repository.findAll();
	}

	//Post
	@PostMapping("/readers")
	public Reader AddReader(@RequestBody Reader reader) {
		return repository.saveAndFlush(reader);
	}

	
	//Update
	@PutMapping("/readerUpdates")
	public Reader updateReader (@RequestBody Reader reader) {
		Reader readerToUpdate = repository.getOne(reader.getId());
		readerToUpdate.setGenre(reader.getGenre());
		readerToUpdate.setNom(reader.getNom());
		readerToUpdate.setPrenom(reader.getPrenom());
		readerToUpdate.setDateDeNaissance(reader.getDateDeNaissance());
		readerToUpdate.setAdresse(reader.getAdresse());
		return repository.saveAndFlush(readerToUpdate);
	}
	
	
	
	//Delete
		@DeleteMapping("/redaersDelete")
		public void deleteRedaer (@RequestBody Reader reader) {
			repository.delete(reader);
		}

	
}
