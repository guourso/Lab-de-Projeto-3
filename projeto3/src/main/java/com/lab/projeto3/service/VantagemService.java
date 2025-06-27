package com.lab.projeto3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.model.Vantagem;
import com.lab.projeto3.repository.AlunoRepository;
import com.lab.projeto3.repository.VantagemRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VantagemService {

    private final VantagemRepository vantagemRepository;
    private final AlunoRepository alunoRepository;

    public Vantagem criar(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public List<Vantagem> listarTodas() {
        return vantagemRepository.findAll();
    }

    public List<Vantagem> listarPorEmpresa(Long idEmpresa) {
        return vantagemRepository.findByEmpresaId(idEmpresa);
    }

    public Vantagem buscarPorId(Long id) {
        return vantagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vantagem não encontrada"));
    }

    @Transactional
    public Vantagem resgatarVantagem(Long vantagemId, Long alunoId) {
        Vantagem vantagem = vantagemRepository.findById(vantagemId)
                .orElseThrow(() -> new EntityNotFoundException("Vantagem não encontrada"));

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        if (aluno.getSaldoMoedas() < vantagem.getCustoMoedas()) {
            throw new IllegalStateException("Saldo insuficiente para resgatar esta vantagem");
        }

        // Deduz o valor da vantagem do saldo do aluno
        aluno.setSaldoMoedas(aluno.getSaldoMoedas() - vantagem.getCustoMoedas());
        alunoRepository.save(aluno);

        return vantagem;
    }
}
