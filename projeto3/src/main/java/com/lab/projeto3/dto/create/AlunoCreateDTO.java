package com.lab.projeto3.dto.create;
import lombok.Data;

@Data
public class AlunoCreateDTO {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String rg;
    private String endereco;
    private String curso;
    private Long instituicaoId;
}
