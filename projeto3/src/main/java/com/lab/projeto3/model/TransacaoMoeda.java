package com.lab.projeto3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TransacaoMoeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Professor professor;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();
}
