package com.lab.projeto3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Professor extends Usuario {

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String departamento;

    @ManyToOne(optional = false)
    private Instituicao instituicao;

    private int saldoMoedas = 0;

    @OneToMany(mappedBy = "professor")
    private List<TransacaoMoeda> transacoesEnviadas = new ArrayList<>();
}
