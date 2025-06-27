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
    private final AlunoRepository alunoRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenBlacklistService tokenBlacklistService;

    public LoginResponseDTO autenticar(LoginRequestDTO dto) {
        Optional<? extends Usuario> usuarioOptional = buscarUsuarioPorEmail(dto.getEmail());

        Usuario usuario = usuarioOptional.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        String token = gerarToken(usuario);
        Double saldoMoedas = null;

        if (usuario instanceof Aluno) {
            saldoMoedas = ((Aluno) usuario).getSaldoMoedas();
        }

        return new LoginResponseDTO(
                token,
                usuario.getRole(),
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                saldoMoedas);
    }

    public void logout(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            tokenBlacklistService.blacklistToken(token);
        }
    }

    private Optional<? extends Usuario> buscarUsuarioPorEmail(String email) {
        Optional<Aluno> aluno = alunoRepo.findByEmail(email);
        if (aluno.isPresent()) {
            return aluno;
        }
        return usuarioRepo.findByEmail(email);
    }

    private String gerarToken(Usuario usuario) {
        return JWT.create()
                .withClaim("role", usuario.getRole().toString())
                .withClaim("id", usuario.getId())
                .withSubject(usuario.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400)) // 24 horas
                .sign(Algorithm.HMAC256(secret));
    }

}
