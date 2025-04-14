package com.lab.projeto3.dto;
import lombok.Data;

@Data
public class VantagemDTO {
    private Long id;
    private String descricao;
    private String fotoUrl;
    private int custo;
    private String empresaNome;
}