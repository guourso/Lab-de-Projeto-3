package com.lab.projeto3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Aluno extends Usuario {

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String curso;

    @ManyToOne(optional = false)
    private Instituicao instituicao;

    private Double saldoMoedas =  0.0;

    @OneToMany(mappedBy = "aluno")
    private List<TransacaoMoeda> transacoesRecebidas = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<TrocaVantagem> trocas = new ArrayList<>();
}
