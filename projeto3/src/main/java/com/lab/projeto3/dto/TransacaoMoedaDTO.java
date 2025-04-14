package com.lab.projeto3.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TransacaoMoedaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private int quantidade;
    private String tipo;
    private String mensagem;
    private String alunoNome;
    private String professorNome;
    private String vantagemDescricao;
}