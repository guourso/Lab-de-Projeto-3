package com.lab.projeto3.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.projeto3.dto.TrocaVantagemDTO;
import com.lab.projeto3.dto.create.TrocaVantagemCreateDTO;
import com.lab.projeto3.mapper.AlunoMapper;
import com.lab.projeto3.mapper.TrocaMapper;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.model.TrocaVantagem;
import com.lab.projeto3.model.Vantagem;
import com.lab.projeto3.service.AlunoService;
import com.lab.projeto3.service.TrocaVantagemService;
import com.lab.projeto3.service.VantagemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trocas")
@RequiredArgsConstructor
public class TrocaVantagemController {

    private final TrocaVantagemService trocaService;
    private final VantagemService vantagemService;
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<TrocaVantagemDTO> trocar(@RequestBody @Valid TrocaVantagemCreateDTO dto) {
        Aluno aluno = AlunoMapper.toEntity(alunoService.buscarPorId(dto.getIdAluno()));
        Vantagem vantagem = vantagemService.buscarPorId(dto.getIdVantagem());
        EmpresaParceira empresaParceira = vantagem.getEmpresa();
        
        if (aluno.getSaldoMoedas() < vantagem.getCustoMoedas()) {
            throw new IllegalArgumentException("Aluno não possui moedas suficientes.");
        }

        aluno.setSaldoMoedas(aluno.getSaldoMoedas() - vantagem.getCustoMoedas());

        TrocaVantagem troca = new TrocaVantagem();
        troca.setAluno(aluno);
        troca.setVantagem(vantagem);
        troca.setCodigoCupom(UUID.randomUUID().toString());
        troca.setValor(vantagem.getCustoMoedas());
        troca.setEmpresa(empresaParceira);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                TrocaMapper.toDTO(trocaService.registrarTroca(troca))
        );
    }

    @GetMapping("/aluno/{id}")
    public List<TrocaVantagemDTO> listarTrocasPorAluno(@PathVariable Long id) {
        return trocaService.listarPorAluno(id).stream().map(TrocaMapper::toDTO).toList();
    }
}
