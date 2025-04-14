package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.TransacaoMoedaDTO;
import com.lab.projeto3.model.TransacaoMoeda;

public class TransacaoMoedaMapper {

    public static TransacaoMoedaDTO toDTO(TransacaoMoeda t) {
        TransacaoMoedaDTO dto = new TransacaoMoedaDTO();
        dto.setId(t.getId());
        dto.setDataHora(t.getDataHora());
        dto.setQuantidade(t.getQuantidade());
        dto.setTipo(t.getTipo());
        dto.setMensagem(t.getMensagem());
        dto.setAlunoNome(t.getAluno() != null ? t.getAluno().getNome() : null);
        dto.setProfessorNome(t.getProfessor() != null ? t.getProfessor().getNome() : null);
        dto.setVantagemDescricao(t.getVantagem() != null ? t.getVantagem().getDescricao() : null);
        return dto;
    }
}