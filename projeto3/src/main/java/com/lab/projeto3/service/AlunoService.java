package com.lab.projeto3.service;

import com.lab.projeto3.dto.AlunoDTO;
import com.lab.projeto3.dto.create.AlunoCreateDTO;
import com.lab.projeto3.enums.Role;
import com.lab.projeto3.mapper.AlunoMapper;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final InstituicaoService instituicaoService;

    public AlunoDTO criar(AlunoCreateDTO alunoCreateDto) {
        Aluno aluno = AlunoMapper.toEntity(alunoCreateDto);
        aluno.setRole(Role.ALUNO);
        aluno.setInstituicao(instituicaoService.buscarPorId(alunoCreateDto.getIdInstituicao()));
        aluno = alunoRepository.save(aluno);
        return AlunoMapper.toDTO(aluno);
    }

    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(AlunoMapper::toDTO)
                .toList();
    }

    public AlunoDTO buscarPorId(Long id) {
        return AlunoMapper.toDTO(alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado")));
    }

}