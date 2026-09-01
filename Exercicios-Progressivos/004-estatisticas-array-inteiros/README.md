# 004 — Estatísticas de um array de inteiros

## Enunciado

Crie um programa em Java que leia uma quantidade entre 1 e 100, armazene os valores informados em um array de inteiros e apresente estatísticas básicas sobre o conjunto.

O programa deve calcular soma, média, maior valor, menor valor, quantidade de elementos acima da média e, ao final, exibir os valores na ordem inversa à entrada.

## Objetivo

Introduzir arrays e percursos com `for`, reaproveitando os conceitos de acumuladores, comparação e média praticados anteriormente.

## Requisitos

1. Ler a quantidade de valores a processar.
2. Aceitar somente quantidades entre 1 e 100.
3. Criar um `int[]` com o tamanho informado.
4. Ler e armazenar todos os valores no array.
5. Acumular a soma em `long` para reduzir risco de overflow do total.
6. Determinar maior e menor valor durante a leitura.
7. Calcular a média após preencher o array.
8. Percorrer o array novamente para contar quantos valores estão acima da média.
9. Exibir os elementos em ordem inversa sem modificar o array original.
10. Utilizar `try-with-resources` para fechar o `Scanner`.

## Exemplo de entrada

```text
5
10
20
30
40
50
```

## Exemplo de saída

```text
Soma: 150
Media: 30.00
Maior: 50
Menor: 10
Acima da media: 2
Ordem inversa: 50 40 30 20 10
```

## Conceitos praticados

- declaração e criação de arrays com `int[]`;
- propriedade `length`;
- acesso por índice;
- laço `for` tradicional;
- `for-each`;
- percursos em sentidos diferentes;
- acumuladores e comparação incremental;
- segunda passagem sobre uma estrutura de dados;
- conversão explícita para `double`;
- validação simples de entrada;
- `Scanner` com `try-with-resources`.

## Abordagem da solução

O array é criado somente depois da validação da quantidade. Durante o primeiro `for`, cada número é armazenado e usado para atualizar soma, maior e menor. A soma permanece em `long`, pois vários valores `int` podem gerar um total fora da faixa de 32 bits.

Depois do preenchimento, a média é calculada. Como a classificação “acima da média” depende do valor final dessa média, é necessária uma segunda passagem pelo array. Esse é o principal avanço em relação ao exercício anterior: os dados deixam de ser apenas consumidos em fluxo e passam a ser preservados para processamento posterior.

A ordem inversa é exibida percorrendo os índices do último elemento até o primeiro. O array não é alterado, evitando trabalho desnecessário apenas para apresentação.

## Validação

| Entrada | Soma | Média | Maior | Menor | Acima da média | Ordem inversa |
| --- | ---: | ---: | ---: | ---: | ---: | --- |
| `10, 20, 30, 40, 50` | 150 | 30.00 | 50 | 10 | 2 | `50 40 30 20 10` |
| `-5, -10, -1` | -16 | -5.33 | -1 | -10 | 2 | `-1 -10 -5` |
| `7` | 7 | 7.00 | 7 | 7 | 0 | `7` |

Também devem ser rejeitadas quantidades menores que 1 ou maiores que 100.

## Executando

A partir do diretório do exercício:

```bash
javac src/Main.java
java -cp src Main
```
