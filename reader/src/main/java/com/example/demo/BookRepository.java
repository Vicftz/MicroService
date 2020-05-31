package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findByTitle(String title);

    public Book findByIsbn(Long isbn);


    
}
