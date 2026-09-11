# 014 — Processamento de pedidos com SOLID

## Enunciado

Implemente um pequeno fluxo de processamento de pedidos no qual a regra de orquestração não dependa diretamente de detalhes de persistência ou notificação.

## Objetivo

Praticar separação de responsabilidades e princípios SOLID, com foco em **SRP** (Single Responsibility Principle) e **DIP** (Dependency Inversion Principle), mantendo o exercício pequeno o suficiente para que as decisões de design sejam explícitas.

## Requisitos

1. modelar um `Pedido` com identificador, cliente e valor total positivo;
2. definir uma abstração `RepositorioPedidos` responsável por persistir pedidos;
3. definir uma abstração `Notificador` responsável por comunicar a confirmação;
4. implementar `ProcessadorPedido` apenas como orquestrador do caso de uso;
5. injetar as dependências pelo construtor, sem instanciá-las dentro do processador;
6. persistir antes de notificar;
7. não notificar quando a persistência falhar;
8. fornecer uma implementação em memória do repositório e uma implementação de notificação via console;
9. proteger a coleção interna do repositório contra alteração externa;
10. validar entradas e dependências obrigatórias;
11. cobrir o comportamento principal com testes automatizados.

## Exemplo

```text
Pedido confirmado para Ana: PED-001
Pedidos persistidos: 1
```

## Conceitos praticados

- separação de responsabilidades;
- SRP — cada classe possui uma responsabilidade principal;
- DIP — o caso de uso depende de interfaces, não de implementações concretas;
- injeção de dependências por construtor;
- interfaces pequenas e coesas;
- test doubles com lambdas;
- encapsulamento de coleção;
- falha rápida para dependências inválidas;
- testes de interação e ordem de efeitos.

## Abordagem da solução

`Pedido` concentra apenas os dados e invariantes do domínio. `RepositorioPedidos` e `Notificador` definem contratos independentes de tecnologia. `ProcessadorPedido` recebe essas abstrações no construtor e apenas coordena a sequência **salvar → notificar**.

Essa separação permite trocar `RepositorioPedidosMemoria` por persistência em arquivo, banco de dados ou outro mecanismo sem alterar o processador. Da mesma forma, `NotificadorConsole` pode ser substituído por e-mail, mensageria ou outro canal sem modificar a regra de orquestração.

O exercício não tenta aplicar todos os princípios SOLID artificialmente. O foco é demonstrar duas decisões concretas e explicáveis: responsabilidade única e inversão de dependência.

## Estrutura

```text
014-processamento-pedidos-solid/
├── README.md
└── src/
    ├── Main.java
    ├── Notificador.java
    ├── NotificadorConsole.java
    ├── Pedido.java
    ├── ProcessadorPedido.java
    ├── ProcessadorPedidoTest.java
    ├── RepositorioPedidos.java
    └── RepositorioPedidosMemoria.java
```

## Validação

```bash
cd Exercicios-Progressivos/014-processamento-pedidos-solid/src
javac *.java
java ProcessadorPedidoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam a ordem persistência/notificação, ausência de notificação quando a persistência falha, encapsulamento da coleção em memória e validações de domínio e dependências.

## Decisões técnicas e trade-offs

O processador não implementa rollback. Se a persistência funcionar e a notificação falhar, o pedido permanecerá salvo. Esse comportamento é intencional nesta etapa: transações, retry, idempotência e mensageria introduziriam preocupações de arquitetura que pertencem a exercícios integradores posteriores.

As interfaces possuem apenas uma operação porque representam a necessidade atual do caso de uso. Métodos adicionais sem demanda real aumentariam a abstração sem benefício concreto.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
