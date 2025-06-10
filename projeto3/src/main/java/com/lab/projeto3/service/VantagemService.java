package com.lab.projeto3.service;

import com.lab.projeto3.model.Vantagem;
import com.lab.projeto3.repository.VantagemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VantagemService {

    private final VantagemRepository vantagemRepository;

    public Vantagem criar(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public List<Vantagem> listarTodas() {
        return vantagemRepository.findAll();
    }

    public List<Vantagem> listarPorEmpresa(Long empresaId) {
        return vantagemRepository.findByEmpresaId(empresaId);
    }

    public Vantagem buscarPorId(Long id) {
        return vantagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vantagem não encontrada"));
    }
}
