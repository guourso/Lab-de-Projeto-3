package com.lab.projeto3.service;

import com.lab.projeto3.dto.create.ProfessorCreateDTO;
import com.lab.projeto3.enums.Role;
import com.lab.projeto3.mapper.ProfessorMapper;
import com.lab.projeto3.model.Professor;
import com.lab.projeto3.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final InstituicaoService instituicaoService;
    private final PasswordEncoder passwordEncoder;

    public Professor criar(ProfessorCreateDTO professorCreateDTO) {
        Professor professorEntity = ProfessorMapper.toEntity(professorCreateDTO);
        professorEntity.setRole(Role.PROFESSOR);
        professorEntity.setSenha(passwordEncoder.encode(professorEntity.getSenha()));
        professorEntity.setDepartamento(professorCreateDTO.getDepartamento());
        professorEntity.setInstituicao(instituicaoService.buscarPorId(professorCreateDTO.getIdInstituicao()));
        return professorRepository.save(professorEntity);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
    }
}
