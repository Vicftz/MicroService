package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturningRepository extends JpaRepository<Returning, Long> {

    public Returning findByIdReader(Long idReader);

    public Optional<Returning> findById(Long id);
}
