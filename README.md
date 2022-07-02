# Gerenciamento de Consultas
Trabalho de avaliação final para matéria de Desenvolvimento de Software.

## Descrição
Caros aluno, como atividade complementar da nossa disciplina, vocês deverão melhorar o sistema de consultas que foi iniciado no começo do semestre.
Para vocês devem utilizar os materiais disponíveis na pasta Projeto Consulta v2 (clique aqui para acessar).

### Funcionalidades

O sistema de gerenciamento de consultas deverá prover, pelo menos as seguintes funcionalidades:
Um menu com as seguinte opções:

- Cadastrar Médico
- Cadastrar Paciente
- Agendar Consulta
- Alterar Consulta
- Buscar Pessoa
- Lista Consultas
- Sair

Cada opção do menu deverá estar modularizada em um método ou classe específico.

### Validações

Os cadastros deverão ter as seguintes validações:

- garantir que entradas numéricas recebam apenas números;
- garantir que entradas do tipo texto, não sejam vazias ou nulas;
- garantir que entradas do tipo data e hora sejam valores válidos;
- entradas como e-mail, telefones, CRM e CEP devem ser validadas;

### Considerações gerais

No caso de agendamento de consultas, deve-se verificar se a data e  hora da consulta é maior ou igual a data e hora atual
também deve-se evitar que uma mesma consulta seja marcada para a mesma data e hora de outra consulta já agendada.
O sistema deve conter uma estrutura de classes onde, uma classe abstrata Pessoa, será superclasse (pai) de Medico e Paciente.
A busca de pessoas deverá ser feita por partes do nome da pessoa.
A funcionalidade Listar Consultas, deverá exibir as consultas ordenadas por Data e Hora, em ordem crescente.
Os códigos desenvolvidos devem ser feitos de forma a permitir o maior aproveitamento de código e legibilidade do seu código.
Isso será levado em consideração na correção.

### Tire dúvidas

Quaisquer dúvidas ou dificuldades, enviem perguntas pelo canal do Discord: https://discord.gg/wRhXDaPD
