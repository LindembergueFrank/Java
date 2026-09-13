# 016 — Agenda de manutenções com modelagem de domínio

## Enunciado

Implemente uma agenda de manutenções que represente solicitações, tipos, estados e intervalos de tempo de forma explícita, impedindo códigos duplicados e conflitos entre agendamentos ativos.

## Objetivo

Aprofundar modelagem de domínio com recursos modernos do Java antes da transição para APIs: `record`, `enum`, `java.time`, `Optional`, imutabilidade e regras de estado.

## Requisitos

1. representar a solicitação de manutenção como um `record`;
2. modelar tipo e status com `enum`, evitando strings livres;
3. utilizar `LocalDateTime` e `Duration` para início e duração;
4. calcular o instante final sem armazenar informação redundante;
5. impedir código duplicado;
6. impedir sobreposição entre agendamentos ativos;
7. considerar intervalos adjacentes válidos, sem conflito;
8. permitir concluir ou cancelar somente agendamentos ainda agendados;
9. permitir que o cancelamento libere o período para outro agendamento;
10. retornar buscas pontuais com `Optional`;
11. retornar a listagem ordenada cronologicamente sem expor uma coleção mutável;
12. cobrir regras de domínio e casos de borda com testes automatizados.

## Exemplo

```text
Codigo: MAN-016
Tipo: PREVENTIVA
Inicio: 2026-09-15T08:00
Fim: 2026-09-15T09:30
Status: AGENDADO
```

## Conceitos praticados

- `record` para um value-like object imutável;
- construtor compacto de `record` para invariantes;
- `enum` para vocabulário fechado de domínio;
- `LocalDateTime` e `Duration`;
- `Optional` para ausência explícita em consultas;
- encapsulamento de transições de estado;
- Streams para consulta e ordenação;
- coleção resultante não mutável;
- regras de sobreposição de intervalos;
- modelagem orientada a comportamento.

## Abordagem

`SolicitacaoManutencao` é um `record` porque seus dados formam uma solicitação imutável e validada. O horário final é derivado de `inicio + duracao`, evitando manter dois campos que poderiam divergir.

`AgendamentoManutencao` contém estado mutável apenas onde o domínio exige: a transição entre `AGENDADO`, `CONCLUIDO` e `CANCELADO`. As operações de mudança ficam dentro da própria classe para impedir transições inválidas.

`AgendaManutencoes` coordena a coleção, rejeita duplicidade e verifica conflitos usando a regra de intervalos semiabertos `[inicio, fim)`: dois agendamentos podem encostar exatamente no limite sem se sobrepor.

A consulta por código usa `Optional` porque a ausência de um agendamento é um resultado normal da busca, não uma exceção.

## Estrutura

```text
016-agenda-manutencoes-dominio/
├── README.md
└── src/
    ├── AgendaManutencoes.java
    ├── AgendaManutencoesTest.java
    ├── AgendamentoManutencao.java
    ├── Main.java
    ├── SolicitacaoManutencao.java
    ├── StatusAgendamento.java
    └── TipoManutencao.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/016-agenda-manutencoes-dominio/src
javac *.java
java AgendaManutencoesTest
java Main
```

Resultado esperado:

```text
Todos os testes passaram.
```

Os testes cobrem criação e consulta, ordenação, imutabilidade da listagem, conflito parcial de horários, intervalos adjacentes, liberação do horário após cancelamento, transições inválidas de status, invariantes do `record` e código duplicado.

## Decisões técnicas e trade-offs

Foi escolhido `LocalDateTime` porque o exercício modela uma agenda local e ainda não trata fusos horários. Em um backend distribuído ou integração entre regiões, a escolha entre `Instant`, `OffsetDateTime` e `ZonedDateTime` precisaria ser feita conforme o contrato da API.

`Optional` é usado apenas no retorno de uma busca que pode legitimamente não encontrar resultado. Ele não é utilizado como atributo do domínio nem como parâmetro.

A agenda usa uma busca linear em memória. Essa decisão mantém o foco na modelagem. Em uma API com persistência, unicidade e consultas de conflito também precisariam ser protegidas no banco de dados e dentro de uma estratégia transacional adequada.

Os testes são executáveis sem framework para manter a estrutura atual da trilha. JUnit será mais apropriado nos exercícios voltados especificamente à evolução da estratégia de testes.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
