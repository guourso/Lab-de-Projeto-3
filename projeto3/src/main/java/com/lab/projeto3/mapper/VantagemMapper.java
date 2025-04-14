package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.VantagemDTO;
import com.lab.projeto3.dto.create.VantagemCreateDTO;
import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.model.Vantagem;

public class VantagemMapper {

    public static VantagemDTO toDTO(Vantagem vantagem) {
        VantagemDTO dto = new VantagemDTO();
        dto.setId(vantagem.getId());
        dto.setDescricao(vantagem.getDescricao());
        dto.setFotoUrl(vantagem.getFotoUrl());
        dto.setCusto(vantagem.getCusto());
        dto.setEmpresaNome(vantagem.getEmpresa() != null ? vantagem.getEmpresa().getNome() : null);
        return dto;
    }

    public static Vantagem toEntity(VantagemCreateDTO dto, EmpresaParceira empresa) {
        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(dto.getDescricao());
        vantagem.setFotoUrl(dto.getFotoUrl());
        vantagem.setCusto(dto.getCusto());
        vantagem.setEmpresa(empresa);
        return vantagem;
    }
}