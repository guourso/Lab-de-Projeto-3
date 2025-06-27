package com.lab.projeto3.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = {"transacoesRecebidas","trocas"})
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instituicao_id", nullable = false)
    @JsonBackReference(value = "instituicao-alunos")
    private Instituicao instituicao;

    @Builder.Default
    private Double saldoMoedas = 0.0;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TransacaoMoeda> transacoesRecebidas = new ArrayList<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TrocaVantagem> trocas = new ArrayList<>();
}
