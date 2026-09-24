# 023 — Reserva de estoque concorrente

## Enunciado

Implemente um estoque em memória que permita reservar unidades de produtos com segurança quando várias threads tentarem alterar o mesmo saldo ao mesmo tempo.

## Objetivo

Introduzir concorrência a partir de uma regra de domínio que exige atomicidade. O exercício demonstra por que uma sequência simples de leitura, validação e escrita pode sofrer condição de corrida e aplica sincronização explícita para preservar invariantes.

## Requisitos

1. cadastrar produto com identificador não vazio e quantidade inicial não negativa;
2. impedir cadastro duplicado;
3. consultar saldo por produto usando `OptionalInt`;
4. reservar somente quantidade positiva;
5. rejeitar reserva de produto inexistente ou sem saldo suficiente;
6. garantir que validação e baixa do saldo sejam uma única operação atômicas;
7. executar reservas concorrentes com `ExecutorService`;
8. preservar saldo nunca negativo mesmo sob contenção;
9. encerrar corretamente o executor;
10. testar o resultado agregado sem depender da ordem de execução das threads.

## Conceitos

- condição de corrida e seção crítica;
- `synchronized` e monitor intrínseco;
- `HashMap` com estado protegido;
- `ExecutorService`, `Future` e `Callable`;
- `OptionalInt`;
- testes concorrentes orientados a invariantes.

## Abordagem

`Estoque` protege as operações que acessam o mapa com métodos `synchronized`. Na reserva, verificar o saldo e gravar o novo valor acontecem sob o mesmo monitor; nenhuma outra thread observa um estado intermediário.

O teste concorrente dispara mais pedidos do que o estoque comporta. Em vez de afirmar qual tarefa vence, soma os resultados e verifica as propriedades relevantes: exatamente o estoque disponível é reservado e o saldo final é zero.

## Trade-offs

Um único monitor simplifica a correção, mas serializa operações de produtos independentes. Em sistemas com alta contenção poderiam ser usados locks por chave, estruturas concorrentes ou persistência com controle transacional. Essas alternativas aumentam complexidade e não são necessárias para demonstrar atomicidade neste estágio.

O exercício usa concorrência real e, portanto, evita testes baseados em temporização ou `Thread.sleep`; as asserções dependem somente de invariantes finais.

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/023-reserva-estoque-concorrente/src
javac *.java
java EstoqueTest
java Main
```

Resultado esperado:

```text
Todos os testes passaram.
```

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
