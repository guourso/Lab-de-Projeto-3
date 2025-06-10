package com.lab.projeto3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.projeto3.dto.VantagemDTO;
import com.lab.projeto3.dto.create.VantagemCreateDTO;
import com.lab.projeto3.mapper.VantagemMapper;
import com.lab.projeto3.model.Vantagem;
import com.lab.projeto3.service.VantagemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vantagens")
@RequiredArgsConstructor
public class VantagemController {

    private final VantagemService vantagemService;

    @PostMapping
    public ResponseEntity<VantagemDTO> criar(@RequestBody @Valid VantagemCreateDTO dto) {
        Vantagem vantagem = vantagemService.criar(VantagemMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(VantagemMapper.toDTO(vantagem));
    }

    @GetMapping
    public List<VantagemDTO> listar() {
        return vantagemService.listarTodas().stream().map(VantagemMapper::toDTO).toList();
    }

    @GetMapping("/empresa/{idEmpresa}")
    public List<VantagemDTO> listarPorEmpresa(@PathVariable Long idEmpresa) {
        return vantagemService.listarPorEmpresa(idEmpresa).stream().map(VantagemMapper::toDTO).toList();
    }
}
