package com.example.desafio.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    private Date dataNascimento;

    private String sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    public Cliente(){}

    public Cliente(String nome, Date dataNascimento, String sexo, List<Endereco> enderecos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
