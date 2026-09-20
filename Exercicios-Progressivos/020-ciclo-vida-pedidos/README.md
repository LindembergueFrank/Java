# 020 — Ciclo de vida de pedidos e invariantes

## Enunciado

Modele um pedido cujo ciclo de vida seja controlado pelo domínio: itens só podem ser alterados enquanto o pedido está em rascunho, a confirmação exige ao menos um item, o pagamento exige valor exatamente igual ao total e pedidos pagos não podem ser cancelados.

## Objetivo

Fechar o bloco 016–020 combinando modelagem de domínio, `enum`, `record`, `Optional`, `BigDecimal`, `Instant`, composição e transições de estado explícitas. O exercício aproxima o Java Core de regras típicas de um futuro serviço REST sem introduzir framework prematuramente.

## Requisitos

1. representar itens e pagamentos como `record` validados;
2. calcular valores monetários com `BigDecimal`;
3. modelar o ciclo `RASCUNHO -> CONFIRMADO -> PAGO`;
4. permitir cancelamento somente a partir de rascunho ou confirmado;
5. impedir confirmação sem itens;
6. impedir alteração dos itens após confirmação;
7. aceitar pagamento somente quando o valor for exatamente igual ao total;
8. registrar o instante do pagamento com `Instant`;
9. expor pagamento ausente/presente com `Optional`;
10. não expor a coleção interna de itens como mutável;
11. cobrir regras e transições inválidas com testes automatizados.

## Conceitos praticados

- encapsulamento orientado a comportamento;
- `enum` como máquina de estados simples;
- `record` para dados imutáveis;
- composição;
- `BigDecimal` para dinheiro;
- `Instant` para evento temporal;
- `Optional` em consulta com ausência legítima;
- Streams e cópia imutável de coleção;
- invariantes e testes de transição.

## Abordagem

`Pedido` é a raiz do pequeno agregado: controla sua lista de itens e todas as mudanças de estado. `ItemPedido` e `Pagamento` são valores imutáveis. O total é derivado dos itens em vez de armazenado, evitando divergência entre estado calculável e persistido.

As transições são métodos com nomes de negócio (`confirmar`, `pagar`, `cancelar`) em vez de um setter de status. Assim, não existe caminho público para colocar o pedido arbitrariamente em um estado incompatível.

## Trade-offs

Um `enum` com validações explícitas é suficiente para quatro estados e poucas transições. Para um workflow muito maior, uma máquina de estados dedicada ou objetos por estado poderiam reduzir condicionais, mas adicionariam complexidade desnecessária aqui.

A igualdade do pagamento com o total é intencional para tornar a invariante clara. Um sistema real poderia modelar pagamentos parciais, múltiplas tentativas, estornos e idempotência.

`Instant` representa adequadamente o momento do pagamento e evita ambiguidade de fuso em eventos de backend. Formatação para horário local pertence à borda da aplicação.

## Estrutura

```text
020-ciclo-vida-pedidos/
├── README.md
└── src/
    ├── ItemPedido.java
    ├── Main.java
    ├── Pagamento.java
    ├── Pedido.java
    ├── PedidoTest.java
    └── StatusPedido.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/020-ciclo-vida-pedidos/src
javac *.java
java PedidoTest
java Main
```

Resultado esperado:

```text
Todos os testes passaram.
```

Os testes cobrem fluxo completo, confirmação sem itens, pagamento divergente, transições inválidas, cancelamento, imutabilidade da listagem e invariantes de entrada.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
