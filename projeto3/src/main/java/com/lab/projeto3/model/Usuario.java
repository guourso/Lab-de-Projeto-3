package com.lab.projeto3.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;
}