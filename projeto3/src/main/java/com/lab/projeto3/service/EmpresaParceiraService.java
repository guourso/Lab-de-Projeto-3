package com.lab.projeto3.service;

import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.repository.EmpresaParceiraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaParceiraService {

    private final EmpresaParceiraRepository empresaRepository;

    public EmpresaParceira criar(EmpresaParceira empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaParceira> listarTodas() {
        return empresaRepository.findAll();
    }

    public EmpresaParceira buscarPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa parceira não encontrada"));
    }
}
