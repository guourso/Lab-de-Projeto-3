package com.lab.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.projeto3.model.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
}