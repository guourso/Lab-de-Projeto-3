package com.lab.projeto3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.projeto3.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);
}