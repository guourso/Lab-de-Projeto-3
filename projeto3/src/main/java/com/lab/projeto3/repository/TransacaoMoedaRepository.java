package com.lab.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.projeto3.model.TransacaoMoeda;

public interface TransacaoMoedaRepository extends JpaRepository<TransacaoMoeda, Long> {
}