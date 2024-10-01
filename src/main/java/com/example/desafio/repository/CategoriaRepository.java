package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
