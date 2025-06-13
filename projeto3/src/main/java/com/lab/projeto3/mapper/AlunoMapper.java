package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.AlunoDTO;
import com.lab.projeto3.dto.create.AlunoCreateDTO;
import com.lab.projeto3.model.Aluno;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setCurso(aluno.getCurso());
        dto.setCpf(aluno.getCpf());
        dto.setRg(aluno.getRg());
        dto.setEndereco(aluno.getEndereco());
        dto.setSaldoMoedas(aluno.getSaldoMoedas());
        dto.setInstituicaoNome(aluno.getInstituicao().getNome());
        return dto;
    }
    public static Aluno toEntity(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setCurso(alunoDTO.getCurso());
        aluno.setCpf(alunoDTO.getCpf());
        aluno.setRg(alunoDTO.getRg());
        aluno.setEndereco(alunoDTO.getEndereco());
        aluno.setSaldoMoedas(alunoDTO.getSaldoMoedas());
        return aluno;
    }
    public static Aluno toEntity(AlunoCreateDTO alunoCreateDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoCreateDTO.getNome());
        aluno.setEmail(alunoCreateDTO.getEmail());
        aluno.setCurso(alunoCreateDTO.getCurso());
        aluno.setCpf(alunoCreateDTO.getCpf());
        aluno.setRg(alunoCreateDTO.getRg());
        aluno.setEndereco(alunoCreateDTO.getEndereco());
        return aluno;
    }
    
}
