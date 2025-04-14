package com.lab.projeto3.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TransacaoMoeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private int quantidade;

    private String tipo; // "ENVIO", "RECEBIMENTO", "TROCA"

    private String mensagem;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Vantagem vantagem; // se for uma troca
}
