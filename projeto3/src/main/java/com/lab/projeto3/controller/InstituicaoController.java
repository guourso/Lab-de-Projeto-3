package com.lab.projeto3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab.projeto3.model.Instituicao;
import com.lab.projeto3.repository.InstituicaoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/instituicoes")
@RequiredArgsConstructor
public class InstituicaoController {

    private final InstituicaoRepository instituicaoRepository;

    @GetMapping
    public List<Instituicao> listarInstituicoes() {
        return instituicaoRepository.findAll();
    }
}