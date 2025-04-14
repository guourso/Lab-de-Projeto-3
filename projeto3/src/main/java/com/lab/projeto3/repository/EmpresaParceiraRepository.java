package com.lab.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.projeto3.model.EmpresaParceira;

public interface EmpresaParceiraRepository extends JpaRepository<EmpresaParceira, Long> {
}