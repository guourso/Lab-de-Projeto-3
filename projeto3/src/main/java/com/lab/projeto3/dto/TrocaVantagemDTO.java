package com.lab.projeto3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrocaVantagemDTO {
    private Long id;
    private String alunoNome;
    private String vantagemDescricao;
    private String codigoCupom;
    private LocalDateTime data;
}
