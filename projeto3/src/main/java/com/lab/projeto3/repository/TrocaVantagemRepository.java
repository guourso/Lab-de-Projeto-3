package com.lab.projeto3.repository;

import com.lab.projeto3.model.TrocaVantagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrocaVantagemRepository extends JpaRepository<TrocaVantagem, Long> {
    List<TrocaVantagem> findByAlunoId(Long alunoId);
}
