# 011 — Análise de vendas com Stream API

## Enunciado

Implemente uma análise de vendas capaz de produzir consultas e agregações derivadas de uma coleção imutável de registros.

O objetivo desta etapa é aplicar **Stream API** em operações que naturalmente formam pipelines de transformação: filtrar vendas por valor, ordenar resultados, mapear entidades para nomes de produtos, somar valores e agrupar totais por categoria.

## Objetivo

Praticar `stream()`, `filter`, `sorted`, `map`, `mapToDouble`, `sum`, `collect` e `Collectors.groupingBy` em um problema pequeno, legível e testável.

O exercício reutiliza conhecimentos anteriores de POO, Collections, Generics, lambdas e method references sem introduzir ainda tratamento de exceções ou persistência em arquivos.

## Requisitos

1. modelar cada venda em uma classe `Venda`;
2. validar produto, categoria e valor na criação;
3. armazenar internamente uma cópia imutável das vendas recebidas;
4. obter os nomes dos produtos acima de um valor mínimo usando pipeline com `filter`, `sorted` e `map`;
5. ordenar esses produtos pelo valor da venda em ordem decrescente;
6. calcular o total vendido com stream numérica;
7. agrupar e somar valores por categoria;
8. preservar uma ordem determinística das categorias no resultado;
9. não alterar a coleção de origem durante nenhuma análise;
10. incluir testes automatizados de comportamento.

## Exemplo

Para as vendas:

```text
Teclado | Perifericos | R$ 180,00
Monitor | Monitores | R$ 1.250,00
Mouse | Perifericos | R$ 95,00
Notebook | Computadores | R$ 4.200,00
Headset | Perifericos | R$ 320,00
```

produtos acima de R$ 300,00 devem resultar em:

```text
[Notebook, Monitor, Headset]
```

O total vendido deve ser `R$ 6.045,00`, e o agrupamento deve produzir os totais de cada categoria.

## Conceitos praticados

- Stream API;
- pipelines de transformação;
- `filter`, `sorted` e `map`;
- streams primitivas com `mapToDouble`;
- redução com `sum`;
- `Collectors.groupingBy` e `Collectors.summingDouble`;
- method references;
- `LinkedHashMap` para ordem determinística;
- imutabilidade estrutural com `List.copyOf` e `Stream.toList()`;
- testes de comportamento.

## Abordagem da solução

`AnaliseVendas` recebe uma coleção de `Venda` e mantém uma cópia imutável. Cada consulta cria um novo pipeline, evitando estado intermediário compartilhado.

`produtosAcimaDe` executa três etapas explícitas: filtra pelo limite, ordena por valor decrescente e transforma cada venda no nome do produto. `totalVendido` converte o stream de objetos em `DoubleStream`, evitando acumulação manual. `totalPorCategoria` usa `groupingBy` com `LinkedHashMap` para manter a ordem de primeira aparição das categorias.

A opção por pipelines curtos favorece legibilidade. Não foi criada uma cadeia única que fizesse múltiplas responsabilidades, pois streams são mais úteis quando cada operação derivada expressa uma intenção clara.

## Estrutura

```text
011-analise-vendas-streams/
├── README.md
└── src/
    ├── Main.java
    ├── Venda.java
    ├── AnaliseVendas.java
    └── AnaliseVendasTest.java
```

## Validação

```bash
cd Exercicios-Progressivos/011-analise-vendas-streams/src
javac *.java
java AnaliseVendasTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam:

- pipeline de filtro, ordenação e mapeamento;
- imutabilidade da lista produzida por `toList()`;
- soma de valores com stream numérica;
- agrupamento e soma por categoria;
- ordem determinística do agrupamento;
- preservação da coleção original;
- rejeição de coleções nulas ou com elementos nulos;
- invariantes básicas da entidade `Venda`.

## Decisões técnicas e trade-offs

`LinkedHashMap` foi fornecido ao `groupingBy` porque a ordem padrão de um `HashMap` não deve ser usada como contrato de apresentação. Aqui a ordem previsível facilita tanto a leitura quanto os testes.

`Stream.toList()` é usado no pipeline de produtos porque retorna uma lista não modificável nas versões modernas do Java utilizadas pelo repositório.

O uso de `double` continua propositalmente simples e didático. Para valores monetários em sistemas reais, `BigDecimal` é geralmente mais apropriado quando precisão decimal exata é requisito.

Streams não substituem automaticamente laços tradicionais. Neste exercício eles são usados onde filtragem, transformação, ordenação e agregação formam pipelines declarativos claros; um laço continuaria válido quando oferecesse maior legibilidade para lógica imperativa complexa.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
