# 017 — Folha de pagamento polimórfica

## Enunciado

Implemente uma folha de pagamento capaz de processar diferentes tipos de funcionário por meio de uma abstração comum, sem condicionais baseadas no tipo concreto de cada objeto.

## Objetivo

Aprofundar **herança, abstração e polimorfismo por subtipo** em um domínio pequeno, utilizando `BigDecimal` para valores monetários e mantendo a classe de folha independente das subclasses concretas.

## Requisitos

1. definir uma classe abstrata `Funcionario` com matrícula, nome e operação de cálculo;
2. implementar ao menos dois vínculos com fórmulas diferentes;
3. processar objetos distintos em uma mesma coleção de `Funcionario`;
4. não usar `instanceof`, `switch` por tipo ou flags para escolher a fórmula;
5. calcular totais monetários com `BigDecimal`;
6. permitir que uma nova subclasse seja processada sem alterar `FolhaPagamento`;
7. gerar resumos imutáveis de pagamento;
8. validar dados de domínio e limites das regras;
9. cobrir polimorfismo, extensibilidade e entradas inválidas com testes.

## Exemplo

```text
F001 - Ana: R$ 3950.75
F002 - Bruno: R$ 5100.00
Total: R$ 9050.75
```

## Conceitos praticados

- classe abstrata;
- sobrescrita de métodos;
- polimorfismo por subtipo;
- substituição de implementações concretas por uma abstração;
- composição de uma coleção heterogênea;
- `BigDecimal` e arredondamento monetário;
- `record` como DTO/resumo imutável;
- Streams e method references;
- bounded wildcard com `List<? extends Funcionario>`;
- Open/Closed Principle como consequência da modelagem.

## Abordagem

`Funcionario` concentra os atributos comuns e define `calcularPagamento()` como comportamento abstrato. `FuncionarioMensalista` e `FuncionarioHorista` implementam a fórmula adequada ao próprio vínculo.

`FolhaPagamento` conhece somente a abstração `Funcionario`. Por isso, percorre uma lista heterogênea chamando o mesmo método sem descobrir o tipo concreto. O despacho dinâmico do Java seleciona a implementação correta em tempo de execução.

O teste de extensibilidade cria uma terceira subclasse apenas no cenário de teste e a entrega à folha sem modificar `FolhaPagamento`. Isso demonstra polimorfismo de subtipo e diferencia este exercício do Strategy: aqui a variação está no próprio objeto de domínio, e não em um algoritmo injetado em um contexto separado.

`ResumoPagamento` é um `record` porque representa apenas um resultado imutável para leitura.

## Estrutura

```text
017-folha-pagamento-polimorfica/
├── README.md
└── src/
    ├── FolhaPagamento.java
    ├── FolhaPagamentoTest.java
    ├── Funcionario.java
    ├── FuncionarioHorista.java
    ├── FuncionarioMensalista.java
    ├── Main.java
    └── ResumoPagamento.java
```

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/017-folha-pagamento-polimorfica/src
javac *.java
java FolhaPagamentoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam as duas subclasses concretas, processamento polimórfico na mesma coleção, inclusão de um terceiro subtipo sem mudança na folha, imutabilidade da lista de resumos e regras de validação.

## Decisões técnicas e trade-offs

A hierarquia foi escolhida porque os objetos representam variações do mesmo conceito de domínio e compartilham estado e contrato. Se as regras de pagamento precisassem variar independentemente do tipo de funcionário, composição com Strategy seria uma alternativa mais flexível.

O limite de 220 horas do funcionário horista é uma regra didática explícita para tornar a validação observável; não representa legislação trabalhista nem regra de produção.

Os cálculos utilizam `BigDecimal` e escala de duas casas decimais. Em sistemas financeiros reais, política de arredondamento, impostos, descontos e moeda precisariam fazer parte de um contrato de domínio mais completo.

Os testes continuam executáveis sem framework para manter consistência com a fase atual da trilha. JUnit será introduzido quando a trilha entrar no bloco dedicado a testes mais estruturados.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
