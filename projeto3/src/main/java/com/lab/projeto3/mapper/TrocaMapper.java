package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.TrocaVantagemDTO;
import com.lab.projeto3.model.TrocaVantagem;

public class TrocaMapper {

    public static TrocaVantagemDTO toDTO(TrocaVantagem troca) {
        TrocaVantagemDTO dto = new TrocaVantagemDTO();
        dto.setId(troca.getId());
        dto.setAlunoNome(troca.getAluno().getNome());
        dto.setVantagemDescricao(troca.getVantagem().getDescricao());
        dto.setCodigoCupom(troca.getCodigoCupom());
        dto.setData(troca.getData());
        return dto;
    }
}
