package com.lab.projeto3.service;

import com.lab.projeto3.model.TrocaVantagem;
import com.lab.projeto3.repository.TrocaVantagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrocaVantagemService {

    private final TrocaVantagemRepository trocaRepository;

    public TrocaVantagem registrarTroca(TrocaVantagem troca) {
        return trocaRepository.save(troca);
    }

    public List<TrocaVantagem> listarPorAluno(Long alunoId) {
        return trocaRepository.findByAlunoId(alunoId);
    }
}
