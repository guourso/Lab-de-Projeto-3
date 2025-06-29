package com.lab.projeto3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransacaoMoedaDTO {
    private Long id;
    private String professorNome;
    private String alunoNome;
    private int quantidade;
    private String motivo;
    private LocalDateTime data;
}
