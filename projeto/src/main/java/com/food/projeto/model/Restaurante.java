package com.food.projeto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String imagem;
    private String descricao;
    private String endereco;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Prato> pratos = new HashSet<>();

    public Restaurante() {}

    public Restaurante(Integer id, String nome, String imagem, String descricao, String endereco, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Restaurante(String nome, String imagem, String descricao, String endereco, String email, String senha) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {return imagem;}

    public void setImagem(String imagem) {this.imagem = imagem;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(Set<Prato> pratos) {
        this.pratos = pratos;
    }
}
