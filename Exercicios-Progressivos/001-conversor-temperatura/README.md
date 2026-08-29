# 001 — Conversor de temperatura

## Enunciado

Crie um programa em Java que leia uma temperatura em graus Celsius e converta o valor para Fahrenheit e Kelvin.

Use as fórmulas:

- `F = (C × 9 / 5) + 32`
- `K = C + 273.15`

## Objetivo

Praticar os fundamentos de um programa Java: método `main`, declaração de variáveis, entrada de dados, operações aritméticas e saída formatada.

## Requisitos

1. Ler uma temperatura em Celsius usando `Scanner`.
2. Armazenar o valor em uma variável do tipo `double`.
3. Calcular Fahrenheit.
4. Calcular Kelvin.
5. Exibir os três valores com duas casas decimais.
6. Fechar o `Scanner` ao final da execução.

## Exemplo de entrada

```text
25
```

## Exemplo de saída

```text
Celsius: 25.00 °C
Fahrenheit: 77.00 °F
Kelvin: 298.15 K
```

## Conceitos praticados

- `public static void main(String[] args)`;
- importação de classes;
- `Scanner`;
- tipo `double`;
- variáveis locais;
- operadores aritméticos;
- precedência de operações;
- `System.out.printf`;
- especificador `%.2f`.

## Abordagem da solução

O programa recebe um único valor decimal em Celsius. Em seguida, aplica diretamente as duas fórmulas de conversão e guarda cada resultado em uma variável. Por fim, `printf` apresenta os valores com duas casas decimais.

A implementação é intencionalmente simples para servir como ponto inicial da sequência de exercícios. Validação de entrada, condicionais e repetição serão introduzidas gradualmente nos próximos problemas.

## Validação

| Celsius | Fahrenheit esperado | Kelvin esperado |
| ---: | ---: | ---: |
| 0.00 | 32.00 | 273.15 |
| 25.00 | 77.00 | 298.15 |
| 100.00 | 212.00 | 373.15 |
| -40.00 | -40.00 | 233.15 |

## Executando

A partir do diretório do exercício:

```bash
javac src/Main.java
java -cp src Main
```
