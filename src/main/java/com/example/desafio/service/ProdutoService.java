package com.example.desafio.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Produto;
import com.example.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto){
        
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(long id){
        Optional<Produto> produtoLocalizado = produtoRepository.findById(id);

        if(produtoLocalizado.isEmpty()){
            throw new InputMismatchException("Não foi possivel encontrar um produto com o id: " + id);
        }

        return produtoLocalizado;
    }

    
    public List<Produto> obterPorIdcategoria(long id){
        List<Produto> produtoLocalizado = produtoRepository.findByCategoriaId(id);

        if(produtoLocalizado.isEmpty()){
            throw new InputMismatchException("Não foi possivel encontrar os produtos com a categoria: " + id);
        }

        return produtoLocalizado;
    }

    public Produto atualizar(long id, Produto produto){
        obterPorId(id);
        produto.setId(id);

        return produtoRepository.save(produto);
    }

    public void deletar(long id){
        obterPorId(id);
        produtoRepository.deleteById(id);
    }

    
}
