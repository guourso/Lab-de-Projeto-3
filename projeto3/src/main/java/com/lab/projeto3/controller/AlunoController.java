package com.lab.projeto3.controller;

import com.lab.projeto3.dto.AlunoDTO;
import com.lab.projeto3.dto.create.AlunoCreateDTO;
import com.lab.projeto3.mapper.AlunoMapper;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoDTO create(@RequestBody AlunoCreateDTO alunoCreateDTO) {
        Aluno aluno = AlunoMapper.toEntity(alunoCreateDTO);
        aluno = alunoRepository.save(aluno);
        return AlunoMapper.toDTO(aluno);
    }

    @GetMapping
    public List<AlunoDTO> getAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AlunoDTO getById(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return AlunoMapper.toDTO(aluno);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable Long id, @RequestBody AlunoCreateDTO alunoCreateDTO) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    
        aluno.setNome(alunoCreateDTO.getNome());
        aluno.setEmail(alunoCreateDTO.getEmail());
        aluno.setCpf(alunoCreateDTO.getCpf());
        aluno.setRg(alunoCreateDTO.getRg());
        aluno.setEndereco(alunoCreateDTO.getEndereco());
        aluno.setCurso(alunoCreateDTO.getCurso());
        // não mexe no aluno.setInstituicao() aqui, deixa como estava
    
        aluno = alunoRepository.save(aluno);
        return AlunoMapper.toDTO(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }
}
