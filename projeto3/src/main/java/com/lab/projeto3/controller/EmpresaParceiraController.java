package com.lab.projeto3.controller;

import com.lab.projeto3.dto.EmpresaParceiraDTO;
import com.lab.projeto3.dto.create.EmpresaParceiraCreateDTO;
import com.lab.projeto3.mapper.EmpresaMapper;
import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.service.EmpresaParceiraService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaParceiraController {

    private final EmpresaParceiraService empresaService;

    @PostMapping("/register")
    public ResponseEntity<EmpresaParceiraDTO> criar(@RequestBody @Valid EmpresaParceiraCreateDTO dto) {
        EmpresaParceira empresa = empresaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmpresaMapper.toDTO(empresa));
    }

    @GetMapping
    public List<EmpresaParceiraDTO> listar() {
        return empresaService.listarTodas().stream().map(EmpresaMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public EmpresaParceiraDTO buscarPorId(@PathVariable Long id) {
        return EmpresaMapper.toDTO(empresaService.buscarPorId(id));
    }
}
