package com.lab.projeto3.dto.create;
import lombok.Data;

@Data
public class VantagemCreateDTO {
    private String descricao;
    private String fotoUrl;
    private int custo;
    private Long empresaId;
}