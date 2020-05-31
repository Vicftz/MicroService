package com.example.demo;


import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Returning {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="isbn")
    private Long isbn;

    @Column(name="id_reader")
    private Long idReader;

    @Column(name="returning_date")
    private String returningDate;



    public Returning() {}
    public Returning(Long id, Long isbn , Long idReader, String returningDate) {
        this.id = id;
        this.isbn = isbn;
        this.idReader = idReader;
        this.returningDate = returningDate;
    }
}
