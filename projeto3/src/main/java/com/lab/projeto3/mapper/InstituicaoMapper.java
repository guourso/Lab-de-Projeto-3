package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.InstituicaoDTO;
import com.lab.projeto3.model.Instituicao;

public class InstituicaoMapper {

    public static InstituicaoDTO toDTO(Instituicao instituicao) {
        InstituicaoDTO dto = new InstituicaoDTO();
        dto.setId(instituicao.getId());
        dto.setNome(instituicao.getNome());
        return dto;
    }

    public static Instituicao toEntity(InstituicaoDTO dto) {
        Instituicao instituicao = new Instituicao();
        instituicao.setId(dto.getId());
        instituicao.setNome(dto.getNome());
        return instituicao;
    }
}