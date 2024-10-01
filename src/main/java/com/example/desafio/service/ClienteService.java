package com.example.desafio.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Cliente;
import com.example.desafio.model.Endereco;
import com.example.desafio.repository.ClienteRepository;
import com.example.desafio.repository.EnderecoRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente adicionar(Cliente cliente){

        Cliente clienteSalvo = clienteRepository.save(cliente);
        List<Endereco> enderecos = cliente.getEnderecos();
    
        for (Endereco endereco : enderecos) {
            endereco.setCliente(clienteSalvo); 
        }
        
        enderecoRepository.saveAll(enderecos); 

        return clienteSalvo;
    }

    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterPorId(long id){
        Optional<Cliente> clienteLocalizado = clienteRepository.findById(id);

        if(clienteLocalizado.isEmpty()){
            throw new InputMismatchException("Não foi possivel encontrar um cliente com o id: " + id);
        }

        return clienteLocalizado;
    }

    public Cliente atualizar(long id, Cliente cliente){
        obterPorId(id);
        cliente.setId(id);
        
        return clienteRepository.save(cliente);
    }

    public void deletar(long id){
        obterPorId(id);
        List<Endereco> enderecos = enderecoRepository.findByClienteId(id);

        for (Endereco endereco : enderecos) {
            enderecoRepository.delete(endereco);         
        }
        
        clienteRepository.deleteById(id);
    }

}
