package com.lab.projeto3.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VantagemCreateDTO {

    @NotBlank
    private String descricao;

    @NotBlank
    private String nome;
    
    @NotNull
    private Double custoMoedas;

    private String urlImagem;

    @NotNull
    private Long idEmpresa;
}
