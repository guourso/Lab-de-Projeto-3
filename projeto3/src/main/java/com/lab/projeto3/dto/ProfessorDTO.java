package com.lab.projeto3.dto;
import lombok.Data;

@Data
public class ProfessorDTO {
    private Long id;
    private String nome;
    private String email;
    private String departamento;
    private String instituicaoNome;
    private int saldoMoedas;
}