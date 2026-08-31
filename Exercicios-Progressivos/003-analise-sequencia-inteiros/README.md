# 003 — Análise de sequência de inteiros

## Enunciado

Crie um programa em Java que leia uma sequência de números inteiros até que o usuário informe `0`. O valor `0` funciona apenas como sentinela de encerramento e não deve entrar nos cálculos.

Ao final, o programa deve apresentar:

- quantidade de valores informados;
- soma dos valores;
- média aritmética;
- quantidade de positivos e negativos;
- quantidade de pares e ímpares;
- maior e menor valor lido.

Se o primeiro valor informado for `0`, o programa deve encerrar informando que não há dados para analisar.

## Objetivo

Introduzir estruturas de repetição com `while`, acumuladores e contadores, combinando-os com condicionais já praticadas nos exercícios anteriores.

## Requisitos

1. Ler números inteiros usando `Scanner`.
2. Encerrar a leitura quando o valor `0` for informado.
3. Não incluir a sentinela nos cálculos.
4. Atualizar soma, quantidade, positivos, negativos, pares e ímpares durante a leitura.
5. Determinar maior e menor valor sem utilizar arrays ou Collections.
6. Calcular a média somente quando houver pelo menos um valor válido.
7. Exibir o resultado de forma organizada.
8. Utilizar `try-with-resources` para fechar o `Scanner`.

## Exemplo de entrada

```text
8
-3
5
10
0
```

## Exemplo de saída

```text
Quantidade: 4
Soma: 20
Media: 5.00
Positivos: 3
Negativos: 1
Pares: 2
Impares: 2
Maior: 10
Menor: -3
```

## Conceitos praticados

- `while`;
- valor sentinela;
- acumuladores e contadores;
- operadores `%`, `>`, `<` e `==`;
- condicionais dentro de laços;
- inicialização controlada de maior e menor valor;
- conversão para `double` no cálculo da média;
- `Scanner` e `try-with-resources`.

## Abordagem da solução

A leitura ocorre dentro de um `while` que termina quando o usuário informa `0`. Para cada valor válido, o programa atualiza os acumuladores e contadores necessários.

Maior e menor não recebem valores artificiais como `Integer.MAX_VALUE` ou `Integer.MIN_VALUE`. Em vez disso, o primeiro número válido inicializa ambos, e os números seguintes são comparados normalmente. Essa abordagem mantém a regra explícita e evita depender de valores-limite externos ao domínio do exercício.

A média é calculada apenas depois que a leitura termina e somente se pelo menos um número tiver sido processado.

## Validação

| Entrada antes do `0` | Quantidade | Soma | Média | Positivos | Negativos | Pares | Ímpares | Maior | Menor |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| `8, -3, 5, 10` | 4 | 20 | 5.00 | 3 | 1 | 2 | 2 | 10 | -3 |
| `-2, -4, -1` | 3 | -7 | -2.33 | 0 | 3 | 2 | 1 | -1 | -4 |
| `7` | 1 | 7 | 7.00 | 1 | 0 | 0 | 1 | 7 | 7 |
| nenhum valor | — | — | — | — | — | — | — | — | — |

## Executando

A partir do diretório do exercício:

```bash
javac src/Main.java
java -cp src Main
```
