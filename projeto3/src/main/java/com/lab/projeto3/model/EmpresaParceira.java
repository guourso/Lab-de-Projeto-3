package com.lab.projeto3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class EmpresaParceira extends Usuario {


    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "empresa")
    private List<Vantagem> vantagens = new ArrayList<>();
}
