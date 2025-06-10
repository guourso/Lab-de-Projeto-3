package com.lab.projeto3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank @Email
    private String email;

    @NotBlank
    private String senha;
}
