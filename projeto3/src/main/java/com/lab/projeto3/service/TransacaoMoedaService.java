package com.lab.projeto3.service;

import com.lab.projeto3.model.TransacaoMoeda;
import com.lab.projeto3.repository.TransacaoMoedaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoMoedaService {

    private final TransacaoMoedaRepository transacaoRepository;

    public TransacaoMoeda registrar(TransacaoMoeda transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<TransacaoMoeda> listarPorAluno(Long alunoId) {
        return transacaoRepository.findByAlunoId(alunoId);
    }

    public List<TransacaoMoeda> listarPorProfessor(Long professorId) {
        return transacaoRepository.findByProfessorId(professorId);
    }
}
