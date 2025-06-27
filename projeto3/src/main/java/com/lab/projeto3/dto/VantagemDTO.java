package com.lab.projeto3.dto;

import lombok.Data;

@Data
public class VantagemDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double custoMoedas;
    private String urlImagem;
    private String empresaNome;
}
