# Contagem de Votos em Eleições

Na contagem de votos de uma eleição, são gerados vários registros de votação contendo o nome do candidato e a quantidade de votos que ele obteve em uma urna de votação. Esses registros são armazenados em formato `.csv`.

## Objetivo

Desenvolver um programa que leia os registros de votação a partir de um arquivo `.csv` e, em seguida, gere um relatório consolidado com o total de votos para cada candidato.

### Regras para Geração do Relatório:
- O arquivo `.csv` conterá os registros com o nome do candidato e a quantidade de votos recebidos em cada urna.
- O programa deve somar os votos de cada candidato e exibir o total consolidado.

## Exemplo

**Entrada (arquivo .csv)**:
```csv

Candidato, Votos
Maria, 30
João, 25
Maria, 12
Ana, 40
João, 22