package com.lab.projeto3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;

}
