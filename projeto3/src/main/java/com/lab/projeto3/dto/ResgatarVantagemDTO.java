package com.lab.projeto3.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResgatarVantagemDTO {
    @NotNull(message = "ID do aluno é obrigatório")
    private Long alunoId;
}
