package com.example.demo;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private Long isbn;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="editor")
    private String editor;

    @Column(name="year")
    private String year;

    @Column(name="type")
    private String type;

    @Column(name="availability")
    private Boolean availability;


    public Book(){}
    public Book(Long isbn, String title, String author, String editor, String year, String type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.year = year;
        this.type = type;
        this.availability=true;
        
    }
}
