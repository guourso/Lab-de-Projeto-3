package com.lab.projeto3.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrocaVantagemCreateDTO {

    @NotNull
    private Long idAluno;

    @NotNull
    private Long idVantagem;
}