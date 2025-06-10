package com.lab.projeto3.repository;

import com.lab.projeto3.model.TransacaoMoeda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoMoedaRepository extends JpaRepository<TransacaoMoeda, Long> {
    List<TransacaoMoeda> findByAlunoId(Long alunoId);
    List<TransacaoMoeda> findByProfessorId(Long professorId);
}
