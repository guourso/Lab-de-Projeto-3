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

import com.lab.projeto3.dto.AlunoDTO;
import com.lab.projeto3.dto.create.AlunoCreateDTO;
import com.lab.projeto3.mapper.AlunoMapper;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping("/register")
    public ResponseEntity<AlunoDTO> criar(@RequestBody @Valid AlunoCreateDTO dto) {
        AlunoDTO alunoDTO = alunoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    @GetMapping
    public List<AlunoDTO> listar() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }
}
