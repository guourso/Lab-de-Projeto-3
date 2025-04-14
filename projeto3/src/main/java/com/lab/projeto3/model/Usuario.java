package com.lab.projeto3.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class Usuario {

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;
}