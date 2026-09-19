# 019 — Contratos, vigência e regras temporais

## Enunciado

Modele contratos com período de vigência, valor mensal e possibilidade de encerramento antecipado. O domínio deve responder qual é a situação de um contrato em uma data de referência sem depender do relógio do sistema.

## Objetivo

Aprofundar modelagem de domínio com `record`, `enum`, `Optional`, `LocalDate`, `Period` e `BigDecimal`, enfatizando regras temporais determinísticas e invariantes úteis em futuros serviços backend.

## Requisitos

1. representar os dados de criação como um `record` validado;
2. impedir código vazio, valor mensal não positivo e data final anterior à inicial;
3. permitir contratos por prazo determinado ou sem data final prevista;
4. encerrar antecipadamente apenas em data válida;
5. calcular a situação (`AGUARDANDO_INICIO`, `ATIVO` ou `ENCERRADO`) a partir de uma data de referência;
6. expor datas opcionais com `Optional`;
7. calcular tempo decorrido usando `Period`;
8. preservar valores monetários com `BigDecimal`;
9. manter regras de negócio fora de `Main`;
10. cobrir limites de datas e transições com testes automatizados.

## Conceitos praticados

- `record` e construtor compacto;
- `enum` como vocabulário fechado;
- `Optional` para ausência legítima;
- `LocalDate` e `Period`;
- `BigDecimal` para dinheiro;
- invariantes e encapsulamento;
- regras temporais determinísticas.

## Abordagem

`DadosContrato` é imutável e valida os dados de entrada. `Contrato` mantém apenas o estado que realmente pode mudar: a data de encerramento antecipado. O status não é armazenado; ele é derivado da data consultada, evitando inconsistência entre campos.

A data de referência é recebida pelos métodos em vez de chamar `LocalDate.now()`. Essa decisão deixa a regra determinística e simples de testar. Em uma aplicação Spring, outra alternativa seria injetar `Clock` quando o caso de uso realmente dependesse do instante atual.

## Trade-offs

`LocalDate` é adequado porque a regra trabalha com dias civis, não instantes. Para auditoria, expiração por horário ou sistemas distribuídos, `Instant`/`OffsetDateTime` seriam escolhas mais adequadas.

`Optional` aparece somente nos retornos cuja ausência faz parte do domínio; não é usado como campo nem parâmetro. O exercício permanece sem framework para consolidar Java Core antes da fase Spring.

## Estrutura

```text
019-contratos-vigencia/
├── README.md
└── src/
    ├── Contrato.java
    ├── ContratoTest.java
    ├── DadosContrato.java
    ├── Main.java
    └── SituacaoContrato.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/019-contratos-vigencia/src
javac *.java
java ContratoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
