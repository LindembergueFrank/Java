# 021 — Fila de atendimento por prioridade

## Enunciado

Implemente uma fila de atendimento em que solicitações sejam processadas pela prioridade e, em caso de empate, pela ordem de chegada. A estrutura também deve permitir consulta rápida pelo identificador sem expor seu estado interno.

## Objetivo

Iniciar o bloco 021–025 aprofundando escolha de estruturas de dados e testes de comportamento. O foco é combinar `PriorityQueue` para ordenação de processamento com `Map` para busca por identificador, deixando explícitos os custos e invariantes dessa decisão.

## Requisitos

1. representar prioridade com `enum`;
2. representar a solicitação como valor imutável;
3. impedir identificadores duplicados;
4. atender primeiro a maior prioridade;
5. preservar ordem de chegada entre solicitações de mesma prioridade;
6. consultar uma solicitação por identificador com `Optional`;
7. remover do índice a solicitação atendida;
8. retornar `Optional.empty()` ao atender uma fila vazia;
9. não expor estruturas mutáveis internas;
10. cobrir regras, empates e casos de borda com testes automatizados.

## Conceitos praticados

- `PriorityQueue` e ordenação por `Comparator`;
- `HashMap` como índice de acesso rápido;
- `enum` e `record`;
- `Optional` para ausência legítima;
- composição de estruturas com responsabilidades diferentes;
- invariantes de unicidade;
- testes organizados por comportamento.

## Abordagem

`FilaAtendimento` mantém duas estruturas sincronizadas: uma `PriorityQueue` decide quem será atendido a seguir e um `HashMap` localiza uma solicitação pelo código. Um número sequencial interno resolve empates de prioridade sem depender do relógio.

A classe pública `Solicitacao` não conhece esse número de ordem. A informação operacional fica em um registro privado da fila, evitando contaminar o modelo de entrada com um detalhe da estrutura de dados.

## Trade-offs

Inserir e retirar da `PriorityQueue` custa `O(log n)`, enquanto a consulta média no `HashMap` é `O(1)`. O custo é manter duas estruturas consistentes. Essa duplicação é justificável porque elas atendem padrões de acesso diferentes.

Uma lista ordenada seria mais simples, mas exigiria busca/inserção linear em algum ponto. Concorrência ainda não é tratada neste exercício: torná-la thread-safe sem necessidade esconderia o aprendizado sobre as estruturas básicas. Sincronização será introduzida progressivamente nos próximos exercícios.

## Exemplo

Com solicitações `NORMAL`, `URGENTE` e `ALTA`, nessa ordem, o atendimento deve ocorrer como `URGENTE`, `ALTA`, `NORMAL`. Duas solicitações `ALTA` são atendidas na ordem em que foram adicionadas.

## Estrutura

```text
021-fila-atendimento-prioridade/
├── README.md
└── src/
    ├── FilaAtendimento.java
    ├── FilaAtendimentoTest.java
    ├── Main.java
    ├── Prioridade.java
    └── Solicitacao.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/021-fila-atendimento-prioridade/src
javac *.java
java FilaAtendimentoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam prioridade, estabilidade em empates, consulta e remoção do índice, duplicidade, fila vazia, validação de entrada e quantidade de elementos.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
