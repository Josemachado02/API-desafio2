package com.example.desafio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Long id;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer cep;

    @Column(nullable = false)
    private String rua;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonBackReference
    private Cliente cliente;

    public Endereco(String bairro, String cidade, String estado, String complemento, Integer numero, Integer cep, String rua, Cliente cliente) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.rua = rua;
        this.cliente = cliente;
    }

    public Endereco(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCEP() {
        return cep;
    }

    public void setCEP(Integer cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
