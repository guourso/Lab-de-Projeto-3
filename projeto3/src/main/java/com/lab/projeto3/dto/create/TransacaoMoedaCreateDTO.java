package com.lab.projeto3.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransacaoMoedaCreateDTO {

    @NotNull
    private Long idProfessor;

    @NotNull
    private Long idAluno;

    @NotNull
    private Integer quantidade;

    @NotBlank
    private String motivo;
}
