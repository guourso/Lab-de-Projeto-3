package com.lab.projeto3.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lab.projeto3.dto.LoginRequestDTO;
import com.lab.projeto3.dto.LoginResponseDTO;
import com.lab.projeto3.dto.create.UsuarioCreateDTO;
import com.lab.projeto3.enums.Role;
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

    private final AlunoRepository alunoRepo;
    private final ProfessorRepository professorRepo;
    private final EmpresaParceiraRepository empresaRepo;
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
        Optional<Usuario> usuario = alunoRepo.findByEmail(email).map(a -> (Usuario) a);
        if (usuario.isEmpty()) {
            usuario = professorRepo.findByEmail(email).map(p -> (Usuario) p);
        }
        if (usuario.isEmpty()) {
            usuario = empresaRepo.findByEmail(email).map(e -> (Usuario) e);
        }
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

    public Usuario cadastrarUsuario(UsuarioCreateDTO usuarioCreate) {
        usuarioCreate.setSenha(passwordEncoder.encode(usuarioCreate.getSenha()));
        Role role = usuarioCreate.getRole();
        if (role == Role.ALUNO) {
            Aluno aluno = new Aluno(usuarioCreate);
            return alunoRepo.save(aluno);
        } else if (role == Role.PROFESSOR) {
            Professor professor = new Professor(usuarioCreate);
            return professorRepo.save(professor);
        } else if (role == Role.EMPRESA_PARCEIRA) {
            EmpresaParceira empresa = new EmpresaParceira(usuarioCreate);
            return empresaRepo.save(empresa);
        }
        
        throw new IllegalArgumentException("Tipo de usuário inválido");
    }
}
