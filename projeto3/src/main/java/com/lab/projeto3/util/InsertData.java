package com.lab.projeto3.util;

import com.lab.projeto3.enums.Role;
import com.lab.projeto3.model.Aluno;
import com.lab.projeto3.model.EmpresaParceira;
import com.lab.projeto3.model.Instituicao;
import com.lab.projeto3.model.Professor;
import com.lab.projeto3.model.Vantagem;
import com.lab.projeto3.repository.AlunoRepository;
import com.lab.projeto3.repository.EmpresaParceiraRepository;
import com.lab.projeto3.repository.InstituicaoRepository;
import com.lab.projeto3.repository.ProfessorRepository;
import com.lab.projeto3.repository.VantagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InsertData {

    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final EmpresaParceiraRepository empresaParceiraRepository;
    private final InstituicaoRepository instituicaoRepository;
    private final VantagemRepository vantagemRepository;

    public InsertData(AlunoRepository alunoRepository,
                      ProfessorRepository professorRepository,
                      EmpresaParceiraRepository empresaParceiraRepository,
                      InstituicaoRepository instituicaoRepository,
                      VantagemRepository vantagemRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.empresaParceiraRepository = empresaParceiraRepository;
        this.instituicaoRepository = instituicaoRepository;
        this.vantagemRepository = vantagemRepository;
    }

    @Transactional
    public void insertData() {
        Instituicao ufmg = Instituicao.builder()
                .nome("Universidade Federal de Minas Gerais (UFMG)")
                .build();

        Instituicao pucMinas = Instituicao.builder()
                .nome("Pontifícia Universidade Católica de Minas Gerais (PUC Minas)")
                .build();

        List<Instituicao> instituicoes = Arrays.asList(ufmg, pucMinas);

        List<Instituicao> intituicoesSalvas = instituicaoRepository.saveAll(instituicoes);

        Aluno aluno1 = Aluno.builder()
                .nome("Maria da Silva")
                .email("maria.silva@email.com")
                .senha("senhaForte123")
                .role(Role.ALUNO)
                .cpf("111.222.333-44")
                .rg("MG-11.111.111")
                .endereco("Rua das Flores, 10, Centro, Belo Horizonte - MG")
                .curso("Sistemas de Informação")
                .instituicao(intituicoesSalvas.get(0))
                .saldoMoedas(50.0)
                .build();

        Aluno aluno2 = Aluno.builder()
                .nome("João Pereira")
                .email("joao.pereira@email.com")
                .senha("outraSenhaSuperSegura456")
                .role(Role.ALUNO)
                .cpf("555.666.777-88")
                .rg("SP-22.222.222")
                .endereco("Avenida Principal, 200, Bairro Sul, São Paulo - SP")
                .curso("Engenharia de Computação")
                .instituicao(intituicoesSalvas.get(1))
                .saldoMoedas(75.0)
                .build();

        List<Aluno> alunos = Arrays.asList(aluno1, aluno2);
        List<Aluno> alunosSalvos = alunoRepository.saveAll(alunos);

        Professor professor1 = Professor.builder()
                .nome("Dr. Roberto Andrade")
                .email("roberto.andrade@ufmg.br")
                .senha("umaSenhaForteParaOProfessor#1")
                .role(Role.PROFESSOR)
                .cpf("999.888.777-66")
                .departamento("Departamento de Ciência da Computação")
                .instituicao(intituicoesSalvas.get(0))
                .saldoMoedas(1000)
                .build();

        Professor professor2 = Professor.builder()
                .nome("Dra. Lúcia Medeiros")
                .email("lucia.medeiros@pucminas.br")
                .senha("outraSenhaForte&2025")
                .role(Role.PROFESSOR)
                .cpf("111.000.222-33")
                .departamento("Departamento de Engenharia de Software")
                .instituicao(intituicoesSalvas.get(1))
                .build();
        List<Professor> professores = Arrays.asList(professor1, professor2);
        List<Professor> professoresSalvos = professorRepository.saveAll(professores);

        EmpresaParceira empresa1 = EmpresaParceira.builder()
                .nome("Google Brasil Internet Ltda.")
                .email("contato-br@google.com")
                .senha("umaSenhaCorporativaSuperSegura1!")
                .role(Role.EMPRESA)
                .cnpj("06.990.590/0001-23")
                .descricao("Empresa multinacional de serviços online e software, focada em busca, " +
                        "computação em nuvem, e publicidade.")
                .build();

        EmpresaParceira empresa2 = EmpresaParceira.builder()

                .nome("Hotmart")
                .email("suporte@hotmart.com")
                .senha("outraSenhaParaParceiro#2025")
                .role(Role.EMPRESA).cnpj("13.427.325/0001-05")
                .descricao("Plataforma global de tecnologia para a creator economy, sediada em Belo Horizonte.")
                .build();

        List<EmpresaParceira> empresasParceiras = Arrays.asList(empresa1, empresa2);
        List<EmpresaParceira> empresasParceirasSalvas = empresaParceiraRepository.saveAll(empresasParceiras);

        Vantagem vantagem1 = Vantagem.builder()
                .nome("Desconto em Cursos Online Google Cloud")
                .descricao("Desconto de 20% em cursos online na plataforma Google Cloud.")
                .custoMoedas(10.0)
                .urlImagem("https://")
                .empresa(empresasParceirasSalvas.get(0))
                .build();

        Vantagem vantagem2 = Vantagem.builder()
                .nome("Acesso Premium Hotmart")
                .descricao("Acesso gratuito por 1 mês ao Hotmart Sparkle, a plataforma de conteúdo exclusivo da Hotmart.")
                .custoMoedas(15.0)
                .urlImagem("https://")
                .empresa(empresasParceirasSalvas.get(1))
                .build();

        List<Vantagem> vantagens = Arrays.asList(vantagem1, vantagem2);
        List<Vantagem> vantagensSalvas = vantagemRepository.saveAll(vantagens);

    }
}
 