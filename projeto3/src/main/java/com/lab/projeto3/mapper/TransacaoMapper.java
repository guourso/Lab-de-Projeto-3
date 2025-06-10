package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.TransacaoMoedaDTO;
import com.lab.projeto3.model.TransacaoMoeda;

public class TransacaoMapper {

    public static TransacaoMoedaDTO toDTO(TransacaoMoeda t) {
        TransacaoMoedaDTO dto = new TransacaoMoedaDTO();
        dto.setId(t.getId());
        dto.setProfessorNome(t.getProfessor().getNome());
        dto.setAlunoNome(t.getAluno().getNome());
        dto.setQuantidade(t.getQuantidade());
        dto.setMotivo(t.getMotivo());
        dto.setData(t.getData());
        return dto;
    }
}
