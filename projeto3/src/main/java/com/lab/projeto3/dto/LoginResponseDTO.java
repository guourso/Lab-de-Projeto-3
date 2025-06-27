package com.lab.projeto3.dto;

import com.lab.projeto3.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private Role role;
    private Long id;
    private String nome;
    private String email;
    private Double saldoMoedas;
}
