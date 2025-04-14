package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.ProfessorDTO;
import com.lab.projeto3.dto.create.ProfessorCreateDTO;
import com.lab.projeto3.model.Instituicao;
import com.lab.projeto3.model.Professor;

public class ProfessorMapper {

    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setEmail(professor.getEmail());
        dto.setDepartamento(professor.getDepartamento());
        dto.setSaldoMoedas(professor.getSaldoMoedas());
        dto.setInstituicaoNome(professor.getInstituicao() != null ? professor.getInstituicao().getNome() : null);
        return dto;
    }

    public static Professor toEntity(ProfessorCreateDTO dto, Instituicao instituicao) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setSenha(dto.getSenha());
        professor.setCpf(dto.getCpf());
        professor.setDepartamento(dto.getDepartamento());
        professor.setInstituicao(instituicao);
        return professor;
    }
}