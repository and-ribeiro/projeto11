package com.food.projeto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private Set<Prato> pratospedido = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    public Pedido(){}

    public Pedido(Integer id, Set<Prato> pratospedido, Usuario usuario) {
        this.id = id;
        this.pratospedido = pratospedido;
        this.usuario = usuario;
    }

    public Pedido(Set<Prato> pratospedido, Usuario usuario) {
        this.pratospedido = pratospedido;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Prato> getPratospedido() {
        return pratospedido;
    }

    public void setPratospedido(Set<Prato> pratospedido) {
        this.pratospedido = pratospedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
