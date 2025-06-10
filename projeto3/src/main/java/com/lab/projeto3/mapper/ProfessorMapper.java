package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.ProfessorDTO;
import com.lab.projeto3.dto.create.ProfessorCreateDTO;
import com.lab.projeto3.model.Professor;

public class ProfessorMapper {

    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setEmail(professor.getEmail());
        dto.setCpf(professor.getCpf());
        dto.setDepartamento(professor.getDepartamento());
        dto.setInstituicaoNome(professor.getInstituicao().getNome());
        dto.setSaldoMoedas(professor.getSaldoMoedas());
        return dto;
    }

    public static Professor toEntity(ProfessorCreateDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setDepartamento(dto.getDepartamento());
        professor.setSenha(dto.getSenha());
        return professor;
    }
}
