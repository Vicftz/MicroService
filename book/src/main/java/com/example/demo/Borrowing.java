package com.example.demo;


import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Borrowing {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="isbn")
    private Long isbn;

    @Column(name="id_reader")
    private Long idReader;

    @Column(name="borrowing_date")
    private String borrowingDate;

    @Column(name="returning_date")
    private String returningDate;



    public Borrowing() {}
    public Borrowing(Long id, Long isbn , Long idReader, String  borrowingDate, String returningDate) {
        this.id = id;
        this.isbn = isbn;
        this.idReader = idReader;
        this.borrowingDate = borrowingDate;
        this.returningDate = returningDate;
    }
}
