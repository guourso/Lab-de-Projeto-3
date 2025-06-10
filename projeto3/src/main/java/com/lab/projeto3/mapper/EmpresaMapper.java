package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.EmpresaParceiraDTO;
import com.lab.projeto3.dto.create.EmpresaParceiraCreateDTO;
import com.lab.projeto3.model.EmpresaParceira;

public class EmpresaMapper {

    public static EmpresaParceiraDTO toDTO(EmpresaParceira empresa) {
        EmpresaParceiraDTO dto = new EmpresaParceiraDTO();
        dto.setId(empresa.getId());
        dto.setNome(empresa.getNome());
        dto.setEmail(empresa.getEmail());
        dto.setDescricao(empresa.getDescricao());
        dto.setCnpj(empresa.getCnpj());
        return dto;
    }

    public static EmpresaParceira toEntity(EmpresaParceiraCreateDTO createDTO) {
        EmpresaParceira empresa = new EmpresaParceira();
        empresa.setNome(createDTO.getNome());
        empresa.setEmail(createDTO.getEmail());
        empresa.setDescricao(createDTO.getDescricao());
        empresa.setCnpj(createDTO.getCnpj());
        return empresa;
    }
}
