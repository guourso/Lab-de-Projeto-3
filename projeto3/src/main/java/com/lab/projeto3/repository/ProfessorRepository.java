package com.lab.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.projeto3.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}