package com.lab.projeto3.service;

import com.lab.projeto3.dto.create.ProfessorCreateDTO;
import com.lab.projeto3.enums.Role;
import com.lab.projeto3.mapper.ProfessorMapper;
import com.lab.projeto3.model.Professor;
import com.lab.projeto3.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor criar(ProfessorCreateDTO professorCreateDTO) {
        //get institui,ão e get departamento
        Professor professorEntity = ProfessorMapper.toEntity(professorCreateDTO);
        professorEntity.setRole(Role.PROFESSOR);
        professorEntity.setSenha(professorCreateDTO.getSenha());
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
