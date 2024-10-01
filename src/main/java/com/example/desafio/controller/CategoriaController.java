package com.example.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Categoria;
import com.example.desafio.service.CategoriaService;

import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    public CategoriaService categoriaService;

     @GetMapping   
    public ResponseEntity<List<Categoria>> obterTodos(){
        return ResponseEntity.ok(categoriaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(categoriaService.obterPorId(id));
    }

    @PostMapping    
    public ResponseEntity<Categoria> adicionar(@RequestBody Categoria categoria){
        var categoriaCriado = categoriaService.adicionar(categoria);
        return new ResponseEntity<>(categoriaCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable long id, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        categoriaService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
