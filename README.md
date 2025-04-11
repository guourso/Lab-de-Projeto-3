[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[REACT__BADGE]: https://img.shields.io/badge/React-005CFE?style=for-the-badge&logo=react
[TYPESCRIPT__BADGE]: https://img.shields.io/badge/typescript-D4FAFF?style=for-the-badge&logo=typescript

# Laboratório-de-Projeto-3 Sistema de Moeda Estudantil

## Sobre
##### Esse repositório tem como objetivo cumprir os requisitos parciais para aprovação na disciplina de Láboratório de Projetos- 2025/1, do curso de Engenharia de Software da PUC MINAS.

O projeto se propõe a criar um sistema de aluguem de automóveis que permita efetuar, cancelar e modificar pedidos através da Internet.


## 📘 Histórias de Usuário

### 🧑‍🎓 Aluno

#### `[Aluno] Cadastro no sistema com dados pessoais e acadêmicos`

**História:**  
Como aluno, desejo me cadastrar no sistema com meus dados pessoais e acadêmicos para participar do programa de moeda estudantil.

**Critérios de Aceitação:**
- O aluno informa nome, email, CPF, RG, endereço, instituição e curso.
- A instituição é selecionada de uma lista pré-cadastrada.

---

#### `[Aluno] Receber moedas dos professores como reconhecimento`

**História:**  
Como aluno, quero receber moedas dos professores como reconhecimento para trocá-las por vantagens.

**Critérios de Aceitação:**
- O aluno recebe notificação por email ao ganhar moedas.
- A mensagem do professor é visível na transação.

---

#### `[Aluno] Visualizar saldo e histórico de transações`

**História:**  
Como aluno, desejo visualizar meu saldo de moedas e o histórico de transações para acompanhar meu desempenho.

**Critérios de Aceitação:**
- O aluno pode acessar um extrato com saldo atual e todas as transações (recebimentos e trocas).

---

#### `[Aluno] Trocar moedas por vantagens`

**História:**  
Como aluno, quero trocar minhas moedas por vantagens oferecidas pelas empresas parceiras.

**Critérios de Aceitação:**
- O aluno pode selecionar vantagens cadastradas e confirmar a troca.
- O valor é descontado do saldo.

---

#### `[Aluno] Receber cupom por email após troca`

**História:**  
Como aluno, desejo receber um cupom por email ao trocar moedas, para utilizá-lo na empresa parceira.

**Critérios de Aceitação:**
- O cupom é enviado por email com código único.
- Um email também é enviado à empresa parceira.

---

### 👨‍🏫 Professor

#### `[Professor] Distribuir moedas para alunos com mensagem de reconhecimento`

**História:**  
Como professor, desejo distribuir moedas para meus alunos como forma de reconhecimento pelo desempenho e participação.

**Critérios de Aceitação:**
- O professor deve ter saldo suficiente.
- Deve informar aluno, quantidade e motivo (mensagem obrigatória).

---

#### `[Professor] Visualizar saldo e histórico de envios`

**História:**  
Como professor, quero visualizar meu saldo de moedas e o histórico de envios para controlar as distribuições feitas.

**Critérios de Aceitação:**
- O extrato exibe saldo atual e todas as transferências com data, aluno e mensagem.

---

#### `[Professor] Acumular moedas a cada semestre`

**História:**  
Como professor, quero acumular moedas não utilizadas a cada semestre para usá-las posteriormente.

**Critérios de Aceitação:**
- A cada semestre são adicionadas 1.000 moedas ao saldo existente.

---

### 🏢 Empresa Parceira

#### `[Empresa Parceira] Cadastro e oferta de vantagens`

**História:**  
Como empresa parceira, desejo me cadastrar no sistema para oferecer vantagens em troca de moedas.

**Critérios de Aceitação:**
- A empresa fornece nome, dados de contato.
- Lista as vantagens com descrição, valor em moedas e foto.

---

#### `[Empresa Parceira] Receber email com cupom gerado após troca`

**História:**  
Como empresa parceira, quero receber notificação por email quando um aluno resgatar uma vantagem para que eu possa validar a troca.

**Critérios de Aceitação:**
- Um email com código exclusivo é enviado para a empresa ao resgate de vantagem.

---

### 🔐 Todos os Usuários

#### `[Todos os Usuários] Login com autenticação`

**História:**  
Como usuário do sistema (aluno, professor ou empresa), desejo acessar o sistema com login e senha para garantir segurança e personalização das funções.

**Critérios de Aceitação:**
- O sistema exige autenticação para acesso.
- Cada tipo de usuário tem permissões específicas.



## Funcionalidades
### 📌 Funcionalidades para Alunos

## Tecnologias
![react][REACT__BADGE]
![typescript][TYPESCRIPT__BADGE]
![spring][SPRING_BADGE]
![java][JAVA_BADGE]

## Contribuidores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/BryanAbreu21">
        <img src="https://avatars.githubusercontent.com/u/127118299?v=4)" width="100px;" alt="Foto de Bryan"/><br>
        <sub>
          <b>Bryan Rosenberg de Abreu</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/guourso">
        <img src="https://avatars.githubusercontent.com/u/62347484?v=4" width="100px;" alt="Foto de Gustavo"/><br>
        <sub>
          <b>Gustavo Henrique Alves Silva</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/VictorFonseca17">
        <img src="https://avatars.githubusercontent.com/u/113562134?v=4" width="100px;" alt="Foto de Victor"/><br>
        <sub>
          <b>Victor Alexandre Peters Fonseca</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
