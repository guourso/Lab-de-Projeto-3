package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.EmpresaParceiraDTO;
import com.lab.projeto3.dto.create.EmpresaParceiraCreateDTO;
import com.lab.projeto3.model.EmpresaParceira;

public class EmpresaParceiraMapper {

    public static EmpresaParceiraDTO toDTO(EmpresaParceira empresa) {
        EmpresaParceiraDTO dto = new EmpresaParceiraDTO();
        dto.setId(empresa.getId());
        dto.setNome(empresa.getNome());
        dto.setEmail(empresa.getEmail());
        return dto;
    }

    public static EmpresaParceira toEntity(EmpresaParceiraCreateDTO dto) {
        EmpresaParceira empresa = new EmpresaParceira();
        empresa.setNome(dto.getNome());
        empresa.setEmail(dto.getEmail());
        empresa.setSenha(dto.getSenha());
        return empresa;
    }
}