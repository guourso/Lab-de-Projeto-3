package com.lab.projeto3.controller;

import com.lab.projeto3.dto.EmpresaParceiraDTO;
import com.lab.projeto3.dto.create.EmpresaParceiraCreateDTO;
import com.lab.projeto3.mapper.EmpresaParceiraMapper;
import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.repository.EmpresaParceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empresas-parceiras")
public class EmpresaParceiraController {

    @Autowired
    private EmpresaParceiraRepository empresaParceiraRepository;

    @PostMapping
    public EmpresaParceiraDTO create(@RequestBody EmpresaParceiraCreateDTO createDTO) {
        EmpresaParceira empresa = EmpresaParceiraMapper.toEntity(createDTO);
        empresa = empresaParceiraRepository.save(empresa);
        return EmpresaParceiraMapper.toDTO(empresa);
    }

    @GetMapping
    public List<EmpresaParceiraDTO> getAll() {
        return empresaParceiraRepository.findAll()
                .stream()
                .map(EmpresaParceiraMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmpresaParceiraDTO getById(@PathVariable Long id) {
        EmpresaParceira empresa = empresaParceiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa Parceira não encontrada"));
        return EmpresaParceiraMapper.toDTO(empresa);
    }

    @PutMapping("/{id}")
    public EmpresaParceiraDTO update(@PathVariable Long id, @RequestBody EmpresaParceiraCreateDTO createDTO) {
        EmpresaParceira empresa = empresaParceiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa Parceira não encontrada"));

        empresa.setNome(createDTO.getNome());
        empresa.setEmail(createDTO.getEmail());
        empresa.setSenha(createDTO.getSenha());
        // Removido setDescricao porque seu DTO e sua entidade não têm descricao no mapper atual

        empresa = empresaParceiraRepository.save(empresa);
        return EmpresaParceiraMapper.toDTO(empresa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        empresaParceiraRepository.deleteById(id);
    }
}
