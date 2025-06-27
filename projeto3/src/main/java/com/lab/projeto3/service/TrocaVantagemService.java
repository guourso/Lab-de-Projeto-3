package com.lab.projeto3.service;

import com.lab.projeto3.model.TrocaVantagem;
import com.lab.projeto3.repository.TrocaVantagemRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrocaVantagemService {

    @Autowired
    private EmailService emailService;

    private final TrocaVantagemRepository trocaRepository;

    public TrocaVantagem registrarTroca(TrocaVantagem troca) {
        try {
            emailService.sendCupomResgateEmails(troca);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao enviar email: Problema com o envio da mensagem. Detalhes: " + e.getMessage(), e);
        }
        return trocaRepository.save(troca);
    }

    public List<TrocaVantagem> listarPorAluno(Long alunoId) {
        return trocaRepository.findByAlunoId(alunoId);
    }
}
