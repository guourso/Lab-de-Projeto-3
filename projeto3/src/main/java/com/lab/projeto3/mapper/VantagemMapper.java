package com.lab.projeto3.mapper;

import com.lab.projeto3.dto.VantagemDTO;
import com.lab.projeto3.dto.create.VantagemCreateDTO;
import com.lab.projeto3.model.Vantagem;

public class VantagemMapper {

    public static VantagemDTO toDTO(Vantagem vantagem) {
        VantagemDTO dto = new VantagemDTO();
        dto.setId(vantagem.getId());
        dto.setNome(vantagem.getNome());
        dto.setDescricao(vantagem.getDescricao());
        dto.setCustoMoedas(vantagem.getCustoMoedas());
        dto.setUrlImagem(vantagem.getUrlImagem());
        dto.setEmpresaNome(vantagem.getEmpresa().getNome());
        return dto;
    }

    public static Vantagem toEntity(VantagemCreateDTO dto) {
        Vantagem vantagem = new Vantagem();
        vantagem.setNome(dto.getNome());
        vantagem.setDescricao(dto.getDescricao());
        vantagem.setCustoMoedas(dto.getCustoMoedas());
        vantagem.setUrlImagem(dto.getUrlImagem());
        return vantagem;
    }

    public static Vantagem toEntity(VantagemDTO dto) {
        Vantagem vantagem = new Vantagem();
        vantagem.setId(dto.getId());
        vantagem.setNome(dto.getNome());
        vantagem.setDescricao(dto.getDescricao());
        vantagem.setCustoMoedas(dto.getCustoMoedas());
        vantagem.setUrlImagem(dto.getUrlImagem());
        return vantagem;
    }
}
