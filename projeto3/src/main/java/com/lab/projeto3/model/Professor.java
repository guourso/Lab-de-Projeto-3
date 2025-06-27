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
@ToString(callSuper = true, exclude = "transacoesEnviadas")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Professor extends Usuario {

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String departamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instituicao_id", nullable = false)
    @JsonBackReference(value = "instituicao-professores")
    private Instituicao instituicao;

    @Builder.Default
    private int saldoMoedas = 0;

    @OneToMany(mappedBy = "professor",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @Builder.Default
    private List<TransacaoMoeda> transacoesEnviadas = new ArrayList<>();
}
