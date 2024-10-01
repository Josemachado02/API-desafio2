package com.example.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Endereco;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    List<Endereco> findByClienteId(Long clienteId); 
}
