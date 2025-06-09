package com.lab.projeto3.dto;

import lombok.Data;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private String curso;
    private String cpf;
    private String rg;
    private String endereco;
    private String instituicaoNome;
    private int saldoMoedas;
}
