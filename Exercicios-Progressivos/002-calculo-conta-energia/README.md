# 002 — Cálculo de conta de energia

## Enunciado

Crie um programa em Java que leia o consumo mensal de energia elétrica de uma residência, em kWh, e calcule o valor da conta usando uma tabela tarifária fictícia.

Considere as seguintes regras:

- consumo de até `100 kWh`: R$ 0,65 por kWh;
- consumo de `101` até `200 kWh`: R$ 0,75 por kWh;
- consumo acima de `200 kWh`: R$ 0,90 por kWh;
- toda conta possui uma taxa fixa de R$ 12,00;
- consumos menores que zero são inválidos e não devem gerar cálculo.

> As tarifas são fictícias e existem apenas para fins de exercício.

## Objetivo

Praticar estruturas condicionais com `if`, `else if` e `else`, combinando validação de entrada, seleção de faixa tarifária e cálculos com valores decimais.

## Requisitos

1. Ler o consumo mensal em kWh usando `Scanner`.
2. Rejeitar consumos negativos com uma mensagem clara.
3. Determinar a tarifa por kWh de acordo com a faixa de consumo.
4. Calcular o valor variável da conta.
5. Somar a taxa fixa de R$ 12,00.
6. Exibir consumo, faixa aplicada, tarifa e valor final com duas casas decimais.
7. Utilizar `try-with-resources` para fechar o `Scanner`.

## Exemplo de entrada

```text
150
```

## Exemplo de saída

```text
Consumo: 150.00 kWh
Faixa: INTERMEDIARIA
Tarifa: R$ 0.75/kWh
Total: R$ 124.50
```

## Conceitos praticados

- `Scanner`;
- tipo `double`;
- constantes locais;
- operadores relacionais;
- `if`, `else if` e `else`;
- validação de entrada;
- seleção de regras de negócio simples;
- `System.out.printf`;
- retorno antecipado com `return`.

## Abordagem da solução

O programa valida primeiro se o consumo é negativo. Nesse caso, informa o erro e encerra o método sem executar cálculos. Para valores válidos, uma cadeia de condicionais escolhe a tarifa e o nome da faixa correspondente. O valor variável é obtido multiplicando o consumo pela tarifa; em seguida, soma-se a taxa fixa.

A tarifa é aplicada integralmente sobre o consumo conforme a faixa alcançada. Esse modelo foi escolhido para manter o foco em condicionais; tarifação progressiva por blocos poderá ser explorada em um exercício posterior.

## Validação

| Consumo (kWh) | Faixa | Tarifa | Total esperado |
| ---: | --- | ---: | ---: |
| 0.00 | BASICA | R$ 0.65 | R$ 12.00 |
| 100.00 | BASICA | R$ 0.65 | R$ 77.00 |
| 150.00 | INTERMEDIARIA | R$ 0.75 | R$ 124.50 |
| 200.00 | INTERMEDIARIA | R$ 0.75 | R$ 162.00 |
| 250.00 | ALTA | R$ 0.90 | R$ 237.00 |
| -1.00 | INVÁLIDO | — | sem cálculo |

## Executando

A partir do diretório do exercício:

```bash
javac src/Main.java
java -cp src Main
```
