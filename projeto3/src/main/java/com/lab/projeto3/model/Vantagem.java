package com.lab.projeto3.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vantagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int custoMoedas;

    private String urlImagem;

    @ManyToOne(optional = false)
    private EmpresaParceira empresa;
}
