package com.lab.projeto3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TrocaVantagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    private Vantagem vantagem;

    @Column(nullable = false)
    private String codigoCupom;

    @ManyToOne
    private EmpresaParceira empresa;

    private Double valor;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();
}
