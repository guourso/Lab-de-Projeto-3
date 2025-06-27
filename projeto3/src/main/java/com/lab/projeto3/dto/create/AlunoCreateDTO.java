package com.lab.projeto3.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlunoCreateDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String endereco;

    @NotBlank
    private String curso;

    @NotNull
    private Long idInstituicao;
}
