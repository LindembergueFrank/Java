# 012 — Controle de estoque com exceções

## Enunciado

Implemente um pequeno controle de estoque que permita adicionar e retirar unidades de um item, diferenciando erros de entrada de uma falha de negócio recuperável: tentar retirar mais unidades do que há disponíveis.

## Objetivo

Praticar tratamento de exceções em Java com `throw`, `throws`, `try/catch`, exceção customizada e preservação de invariantes do objeto após uma operação recusada.

O exercício reutiliza POO e testes já praticados, mas não introduz ainda leitura/escrita de arquivos, SOLID ou padrões de projeto.

## Requisitos

1. modelar um item de estoque com nome e quantidade atual;
2. rejeitar nome vazio e quantidade inicial negativa com `IllegalArgumentException`;
3. permitir adicionar apenas quantidades positivas;
4. permitir retirar apenas quantidades positivas;
5. criar `EstoqueInsuficienteException` para representar tentativa de retirada superior ao saldo disponível;
6. tornar a exceção de estoque insuficiente uma checked exception;
7. expor na exceção o produto, a quantidade solicitada e a quantidade disponível;
8. preservar o estoque quando a retirada falhar;
9. demonstrar tratamento com `try/catch` em `Main`;
10. cobrir cenários válidos e inválidos com testes automatizados.

## Exemplo

Com um item `Teclado` iniciado com 5 unidades:

```text
retirar 2 -> quantidade = 3
retirar 4 -> EstoqueInsuficienteException
quantidade após a falha = 3
```

## Conceitos praticados

- hierarquia de exceções;
- checked exceptions;
- `throw` e `throws`;
- `try/catch`;
- exceção customizada com contexto de domínio;
- `IllegalArgumentException` para violação de pré-condições;
- invariantes e atualização de estado somente após validação;
- testes de comportamento e de falha;
- interface funcional auxiliar para testar operações que lançam exceções checked.

## Abordagem da solução

`ItemEstoque` concentra o estado e as regras de alteração da quantidade. Erros de programação ou entrada inválida, como quantidade zero ou negativa, usam `IllegalArgumentException` porque violam o contrato do método.

Já a falta de estoque é tratada como uma condição de negócio previsível e recuperável. Por isso, `EstoqueInsuficienteException` estende `Exception`, obrigando quem chama `retirar` a decidir se captura ou propaga a falha.

A retirada só altera o estado depois de todas as validações. Assim, uma tentativa recusada não deixa o objeto parcialmente modificado.

## Estrutura

```text
012-controle-estoque-excecoes/
├── README.md
└── src/
    ├── Main.java
    ├── ItemEstoque.java
    ├── EstoqueInsuficienteException.java
    └── ItemEstoqueTest.java
```

## Validação

```bash
cd Exercicios-Progressivos/012-controle-estoque-excecoes/src
javac *.java
java ItemEstoqueTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam:

- entrada e saída de estoque em cenário válido;
- lançamento da exceção customizada;
- preservação da quantidade após retirada recusada;
- dados de contexto armazenados na exceção;
- rejeição de nome vazio, quantidade inicial negativa e movimentações não positivas.

## Decisões técnicas e trade-offs

A exceção de estoque insuficiente foi modelada como checked exception para tornar explícita, nesta etapa didática, a obrigação de tratar ou propagar uma falha de negócio previsível. Em aplicações maiores, a escolha entre checked e unchecked exceptions depende do estilo arquitetural, das fronteiras da aplicação e de como erros de domínio são representados.

`IllegalArgumentException` continua unchecked porque representa quebra imediata do contrato de entrada, não uma condição operacional que o fluxo normal de negócio deva necessariamente recuperar.

A classe ainda representa apenas um item isolado. Um catálogo com vários itens, persistência em arquivo ou serviços de aplicação adicionaria responsabilidades que desviariam o foco desta etapa.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
