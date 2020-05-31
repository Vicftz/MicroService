package com.example.demo;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Reader {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="genre")
    private String genre;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="date_de_naissance")
    private String dateDeNaissance;

    @Column(name="adresse")
    private String adresse;


    public Reader(){}
    public Reader(Long id, String genre, String nom, String prenom, String dateDeNaissance, String adresse) {
        this.id = id;
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;

        
    }
}
