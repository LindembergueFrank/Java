# 015 — Cálculo de frete com Strategy

## Enunciado

Implemente um cálculo de frete em que diferentes regras de preço possam ser selecionadas sem alterar a classe que coordena o cálculo.

## Objetivo

Praticar o padrão comportamental **Strategy** em um problema pequeno e verificável, consolidando interfaces, composição e inversão de dependência já estudadas.

## Requisitos

1. modelar um `PedidoEnvio` com código e peso positivo;
2. definir `PoliticaFrete` como contrato para algoritmos de cálculo;
3. implementar políticas econômica e expressa com tarifas distintas;
4. manter `CalculadoraFrete` independente das implementações concretas;
5. permitir uma nova política sem modificar a calculadora;
6. representar valores monetários com `BigDecimal`;
7. rejeitar dependências, pedidos ou resultados de estratégia inválidos;
8. cobrir o comportamento principal com testes automatizados.

## Exemplo

```text
Pedido: PED-015
Frete economico: R$ 12.20
Frete expresso: R$ 26.75
```

## Conceitos praticados

- Strategy Pattern;
- composição em vez de condicionais por tipo;
- interfaces funcionais;
- injeção por construtor;
- Open/Closed Principle em um caso concreto;
- `BigDecimal` para cálculos monetários;
- validação de contrato entre contexto e estratégia;
- testes de extensibilidade.

## Abordagem da solução

`PoliticaFrete` representa o algoritmo variável. `FreteEconomico` e `FreteExpresso` encapsulam fórmulas diferentes. `CalculadoraFrete` atua como contexto e conhece apenas a abstração recebida no construtor.

O teste com uma política de retirada local implementada por lambda demonstra o ponto central do padrão: adicionar um novo comportamento sem editar a calculadora existente. Isso evita um `if`/`switch` crescente baseado no tipo de entrega.

## Estrutura

```text
015-calculo-frete-strategy/
├── README.md
└── src/
    ├── CalculadoraFrete.java
    ├── CalculadoraFreteTest.java
    ├── FreteEconomico.java
    ├── FreteExpresso.java
    ├── Main.java
    ├── PedidoEnvio.java
    └── PoliticaFrete.java
```

## Validação

```bash
cd Exercicios-Progressivos/015-calculo-frete-strategy/src
javac *.java
java CalculadoraFreteTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam as duas estratégias concretas, extensão por uma terceira estratégia sem mudança na calculadora e falhas de contrato para entradas ou retornos inválidos.

## Decisões técnicas e trade-offs

As tarifas ficam nas próprias estratégias para manter o exercício autocontido. Em uma aplicação real, preços provavelmente viriam de configuração ou serviço externo. Introduzir essa infraestrutura aqui esconderia o objetivo didático do padrão.

A calculadora valida também o retorno da estratégia. Isso torna explícito o contrato de que um frete não pode ser `null` nem negativo, impedindo uma implementação defeituosa de propagar estado inválido.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
