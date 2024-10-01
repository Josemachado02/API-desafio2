package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
