# 010 — Relatório de vendas com lambdas

## Enunciado

Implemente um pequeno relatório de vendas capaz de filtrar e ordenar registros conforme critérios fornecidos pelo código cliente.

O objetivo não é criar métodos específicos como `filtrarPorVendedor`, `filtrarPorValor` ou `ordenarPorProduto`. Em vez disso, o relatório deve receber comportamentos por meio das interfaces funcionais da biblioteca padrão e permitir que lambdas expressem diferentes critérios sem duplicar a lógica de iteração.

## Objetivo

Praticar **expressões lambda** em um problema onde passar comportamento como argumento reduz duplicação e melhora a flexibilidade da API.

O exercício consolida POO, Collections e Generics já vistos, introduzindo `Predicate<T>`, `Comparator<T>`, method references e funções de alta ordem sem utilizar Stream API.

## Requisitos

O exercício deve:

1. modelar cada venda em `RegistroVenda`;
2. validar produto, vendedor e valor na criação;
3. manter os registros de origem encapsulados e estruturalmente imutáveis;
4. permitir filtrar vendas recebendo um `Predicate<RegistroVenda>`;
5. permitir ordenar vendas recebendo um `Comparator<RegistroVenda>`;
6. não alterar a ordem da coleção original durante filtros ou ordenações;
7. retornar resultados que não possam ser modificados estruturalmente pelo chamador;
8. demonstrar pelo menos dois filtros com lambdas;
9. demonstrar ordenação usando `Comparator` e method reference;
10. não utilizar Stream API nesta etapa.

## Exemplo

Considerando as vendas:

```text
Teclado - Ana - R$ 180,00
Monitor - Bruno - R$ 1.250,00
Mouse - Ana - R$ 95,00
Notebook - Carla - R$ 4.200,00
```

um filtro pode ser expresso como:

```java
venda -> venda.getValor() > 500.00
```

e a ordenação decrescente por valor como:

```java
Comparator.comparingDouble(RegistroVenda::getValor).reversed()
```

## Conceitos praticados

- expressões lambda;
- interfaces funcionais;
- `Predicate<T>`;
- `Comparator<T>`;
- method references;
- comportamento passado como argumento;
- Collections e Generics;
- cópia defensiva com `List.copyOf`;
- ordenação sem mutar a fonte;
- separação de responsabilidades;
- testes de comportamento.

## Abordagem da solução

`RelatorioVendas` mantém uma cópia imutável da lista recebida. O método `filtrar` percorre os registros e usa `Predicate.test` para decidir quais elementos entram no resultado. Dessa forma, o algoritmo de filtragem permanece único e o critério varia por lambda.

`ordenar` recebe um `Comparator<RegistroVenda>`, cria uma nova lista a partir da fonte e ordena apenas essa cópia. Isso evita efeitos colaterais sobre o estado original e permite reutilizar o mesmo relatório com diferentes estratégias de ordenação.

Essa abordagem introduz a ideia de **passar comportamento**, preparando a base para Stream API sem misturar os dois conceitos no mesmo exercício.

## Estrutura

```text
010-relatorio-vendas-lambdas/
├── README.md
└── src/
    ├── Main.java
    ├── RegistroVenda.java
    ├── RelatorioVendas.java
    └── RelatorioVendasTest.java
```

## Validação

Compile os arquivos:

```bash
cd Exercicios-Progressivos/010-relatorio-vendas-lambdas/src
javac *.java
```

Execute os testes:

```bash
java RelatorioVendasTest
```

Resultado esperado:

```text
Todos os testes passaram.
```

Execute também a demonstração:

```bash
java Main
```

Os testes verificam:

- filtro por vendedor usando lambda;
- filtro por valor usando lambda;
- ordenação numérica com `Comparator.comparingDouble`;
- ordenação textual com `Comparator.comparing`;
- preservação da ordem original após operações derivadas;
- imutabilidade estrutural das listas retornadas;
- rejeição de lista nula ou contendo elementos nulos;
- rejeição de critérios e comparadores nulos;
- invariantes básicas de `RegistroVenda`.

## Decisões técnicas

O exercício usa `Predicate<RegistroVenda>` e `Comparator<RegistroVenda>` porque são interfaces funcionais padrão e evitam criar abstrações próprias sem necessidade.

A filtragem foi implementada com laço tradicional propositalmente. O foco é compreender lambdas como valores de comportamento antes de introduzir pipelines com Stream API no próximo avanço da trilha.

`double` é mantido para valores monetários por coerência com o nível atual dos exercícios. Em software financeiro real, `BigDecimal` seria uma escolha mais adequada para evitar problemas de precisão binária.

O exercício representa estudo progressivo da linguagem e não é apresentado como componente pronto para produção.
