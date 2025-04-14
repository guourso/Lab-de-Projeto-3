package com.lab.projeto3.dto.create;
import lombok.Data;

@Data
public class ProfessorCreateDTO {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String departamento;
    private Long instituicaoId;
}