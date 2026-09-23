# 022 — Limitador de requisições por janela deslizante

## Enunciado

Implemente um limitador em memória que aceite no máximo uma quantidade configurável de requisições por cliente dentro de uma janela de tempo. O comportamento deve ser determinístico e testável sem depender do relógio do sistema.

## Objetivo

Aprofundar estruturas de dados e testes de fronteira antes da entrada em concorrência. O exercício combina `Map` e `ArrayDeque`, modelagem temporal com `Duration`/`Instant` e injeção de `Clock`, conceito útil em backends para rate limiting e regras dependentes de tempo.

## Requisitos

1. configurar limite positivo e janela de duração positiva;
2. identificar cada cliente por uma chave não vazia;
3. permitir requisições enquanto o cliente estiver abaixo do limite;
4. rejeitar novas requisições quando o limite da janela for atingido;
5. expirar registros antigos antes de decidir;
6. considerar expirado um registro exatamente no início da janela atual;
7. manter histórico independente por cliente;
8. permitir consultar quantas requisições ainda estão ativas para um cliente;
9. usar `Clock` injetável para que os testes não dependam de espera real;
10. cobrir limites temporais, isolamento entre clientes e entradas inválidas.

## Conceitos praticados

- `HashMap` para particionar estado por chave;
- `ArrayDeque` como fila temporal eficiente nas extremidades;
- `Instant`, `Duration` e `Clock`;
- remoção amortizada de eventos expirados;
- invariantes e encapsulamento de estado mutável;
- testes determinísticos de regras temporais.

## Abordagem

Cada cliente possui uma `ArrayDeque<Instant>` ordenada pela chegada. Antes de autorizar ou consultar, o limitador remove do início da fila os instantes que ficaram fora da janela. Assim, cada registro entra e sai da deque uma única vez.

O relógio é uma dependência explícita. Em produção poderia ser usado `Clock.systemUTC()`; nos testes, um relógio controlável permite avançar o tempo sem `Thread.sleep`, reduzindo lentidão e flakiness.

## Trade-offs

A solução mantém estado em memória e, portanto, não compartilha limites entre processos nem sobrevive a reinicializações. Isso é adequado ao objetivo do exercício, mas um backend distribuído exigiria armazenamento/coordenação externos e decisões adicionais sobre consistência.

O acesso ainda não é thread-safe. Sincronizar prematuramente esconderia as propriedades da estrutura; concorrência e coordenação serão introduzidas nos próximos exercícios.

## Exemplo

Com limite `2` e janela de `10s`, duas requisições do mesmo cliente são aceitas e a terceira é rejeitada. Após avançar exatamente `10s` desde as duas primeiras, ambas expiram e uma nova requisição volta a ser aceita.

## Estrutura

```text
022-limitador-requisicoes-janela/
├── README.md
└── src/
    ├── LimiteRequisicoes.java
    ├── LimiteRequisicoesTest.java
    ├── Main.java
    └── RelogioAjustavel.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/022-limitador-requisicoes-janela/src
javac *.java
java LimiteRequisicoesTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam limite, expiração, fronteira exata da janela, isolamento entre clientes, consulta de estado e validação das entradas.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
