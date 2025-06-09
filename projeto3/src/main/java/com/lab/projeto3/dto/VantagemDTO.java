package com.lab.projeto3.dto;

import lombok.Data;

@Data
public class VantagemDTO {
    private Long id;
    private String descricao;
    private int custoMoedas;
    private String urlImagem;
    private String empresaNome;
}
