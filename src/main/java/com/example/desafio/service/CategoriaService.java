package com.example.desafio.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Categoria;
import com.example.desafio.model.Produto;
import com.example.desafio.repository.CategoriaRepository;
import com.example.desafio.repository.ProdutoRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Categoria adicionar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(long id){
        Optional<Categoria> categoriaLocalizado = categoriaRepository.findById(id);

        if(categoriaLocalizado.isEmpty()){
            throw new InputMismatchException("Não foi possivel encontrar uma categoria com o id: " + id);
        }

        return categoriaLocalizado;
    }

    public Categoria atualizar(long id, Categoria categoria){
        obterPorId(id);
        categoria.setId(id);

        return categoriaRepository.save(categoria);
    }

    public void deletar(long id){
        obterPorId(id);
        List<Produto> produtos = produtoRepository.findByCategoriaId(id);
        if (! produtos.isEmpty()){
            throw new InputMismatchException("Não foi possivel deletar a categoria " + id + " pois tem produtos vinculados a ela");
        }

        categoriaRepository.deleteById(id);
    }
}
