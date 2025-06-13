package com.lab.projeto3.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lab.projeto3.dto.LoginRequestDTO;
import com.lab.projeto3.dto.LoginResponseDTO;
import com.lab.projeto3.model.*;
import com.lab.projeto3.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${jwt.secret}")
    private String secret;

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        Optional<? extends Usuario> usuarioOptional = buscarUsuarioPorEmail(dto.getEmail());

        Usuario usuario = usuarioOptional.orElseThrow(() ->
                new EntityNotFoundException("Usuário não encontrado."));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        String token = gerarToken(usuario);
        return new LoginResponseDTO(token, usuario.getRole());
    }

    private Optional<Usuario> buscarUsuarioPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        return usuario;
    }

    private String gerarToken(Usuario usuario) {
        return JWT.create()
                .withClaim("role", usuario.getRole().toString())
                .withSubject(usuario.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(60 * 60)) // 1 hora
                .sign(Algorithm.HMAC256(secret));
    }

}
