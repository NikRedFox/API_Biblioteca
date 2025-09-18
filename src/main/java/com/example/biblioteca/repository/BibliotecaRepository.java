package com.example.biblioteca.repository;

import com.example.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{
}
