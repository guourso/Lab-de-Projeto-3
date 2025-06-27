package com.lab.projeto3.service;

import com.lab.projeto3.dto.create.EmpresaParceiraCreateDTO;
import com.lab.projeto3.enums.Role;
import com.lab.projeto3.mapper.EmpresaMapper;
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

    public EmpresaParceira criar(EmpresaParceiraCreateDTO empresaCreateDTO) {
        EmpresaParceira empresa = EmpresaMapper.toEntity(empresaCreateDTO);
        System.out.println("DADOS DO OBJETO RECEBIDO:" + empresa.getCnpj() + " " +  empresa.getEmail()+ " " + empresa.getNome());
        empresa.setRole(Role.EMPRESA);
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
