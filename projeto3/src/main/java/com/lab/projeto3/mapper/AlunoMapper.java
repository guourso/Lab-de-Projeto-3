package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.AlunoDTO;
import com.lab.projeto3.dto.InstituicaoDTO;
import com.lab.projeto3.dto.create.AlunoCreateDTO;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.model.Instituicao;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setCurso(aluno.getCurso());
        dto.setSaldoMoedas(aluno.getSaldoMoedas());
        dto.setInstituicaoNome(aluno.getInstituicao() != null ? aluno.getInstituicao().getNome() : null);
        return dto;
    }

    public static Aluno toEntity(AlunoCreateDTO dto ) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setSenha(dto.getSenha());
        aluno.setCpf(dto.getCpf());
        aluno.setRg(dto.getRg());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCurso(dto.getCurso());
        return aluno;
    }

    public static Aluno toEntity(AlunoDTO dto, InstituicaoDTO instituicao) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setCurso(dto.getCurso());
        aluno.setSaldoMoedas(dto.getSaldoMoedas());
        aluno.setInstituicao(new Instituicao());
        aluno.getInstituicao().setNome(instituicao.getNome());
        aluno.getInstituicao().setId(instituicao.getId());
        return aluno;
    }
}