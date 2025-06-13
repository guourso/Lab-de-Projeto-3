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

import com.lab.projeto3.dto.TransacaoMoedaDTO;
import com.lab.projeto3.dto.create.TransacaoMoedaCreateDTO;
import com.lab.projeto3.mapper.AlunoMapper;
import com.lab.projeto3.mapper.TransacaoMapper;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.model.Professor;
import com.lab.projeto3.model.TransacaoMoeda;
import com.lab.projeto3.service.AlunoService;
import com.lab.projeto3.service.ProfessorService;
import com.lab.projeto3.service.TransacaoMoedaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transacoes")
@RequiredArgsConstructor
public class TransacaoMoedaController {

    private final TransacaoMoedaService transacaoService;
    private final ProfessorService professorService;
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<TransacaoMoedaDTO> registrar(@RequestBody @Valid TransacaoMoedaCreateDTO dto) {
        Professor professor = professorService.buscarPorId(dto.getIdProfessor());
        Aluno aluno = AlunoMapper.toEntity(alunoService.buscarPorId(dto.getIdAluno()));

        if (professor.getSaldoMoedas() < dto.getQuantidade()) {
            throw new IllegalArgumentException("Professor não possui saldo suficiente.");
        }

        professor.setSaldoMoedas(professor.getSaldoMoedas() - dto.getQuantidade());
        aluno.setSaldoMoedas(aluno.getSaldoMoedas() + dto.getQuantidade());

        TransacaoMoeda transacao = new TransacaoMoeda();
        transacao.setProfessor(professor);
        transacao.setAluno(aluno);
        transacao.setMotivo(dto.getMotivo());
        transacao.setQuantidade(dto.getQuantidade());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                TransacaoMapper.toDTO(transacaoService.registrar(transacao))
        );
    }

    @GetMapping("/aluno/{id}")
    public List<TransacaoMoedaDTO> listarPorAluno(@PathVariable Long id) {
        return transacaoService.listarPorAluno(id).stream().map(TransacaoMapper::toDTO).toList();
    }

    @GetMapping("/professor/{id}")
    public List<TransacaoMoedaDTO> listarPorProfessor(@PathVariable Long id) {
        return transacaoService.listarPorProfessor(id).stream().map(TransacaoMapper::toDTO).toList();
    }
}
