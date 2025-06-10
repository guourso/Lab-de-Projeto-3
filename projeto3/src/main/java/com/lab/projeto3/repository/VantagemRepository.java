package com.lab.projeto3.repository;

import com.lab.projeto3.model.Vantagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VantagemRepository extends JpaRepository<Vantagem, Long> {
    List<Vantagem> findByEmpresaId(Long empresaId);
}
