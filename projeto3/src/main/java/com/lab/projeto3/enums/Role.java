package com.lab.projeto3.enums;

public enum  Role {
    ALUNO(1),
    PROFESSOR(2),
    EMPRESA(3);

        private final int value;

        Role(int valor) {
        this.value = valor;
    }

    public static Role getFromValue(int valor) {
        for (Role role : Role.values()) {
            if (role.value == valor) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }
}