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

import com.lab.projeto3.dto.ProfessorDTO;
import com.lab.projeto3.dto.create.ProfessorCreateDTO;
import com.lab.projeto3.mapper.ProfessorMapper;
import com.lab.projeto3.model.Professor;
import com.lab.projeto3.service.ProfessorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> criar(@RequestBody @Valid ProfessorCreateDTO dto) {
        Professor prof = professorService.criar(ProfessorMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfessorMapper.toDTO(prof));
    }

    @GetMapping
    public List<ProfessorDTO> listar() {
        return professorService.listarTodos().stream().map(ProfessorMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ProfessorDTO buscarPorId(@PathVariable Long id) {
        return ProfessorMapper.toDTO(professorService.buscarPorId(id));
    }
}
