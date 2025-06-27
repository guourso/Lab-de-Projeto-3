package com.lab.projeto3.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(exclude = {"alunos", "professores"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "instituicao",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonManagedReference(value = "instituicao-alunos")
    @Builder.Default
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "instituicao",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonManagedReference(value = "instituicao-professores")
    @Builder.Default
    private List<Professor> professores = new ArrayList<>();
}
