# Exercicio 1
## Sistema de Gerenciamento de Funcionários

Este programa gerencia um conjunto de funcionários, permitindo a leitura dos dados de funcionários e o ajuste de salários com base em uma porcentagem especificada.

### Funcionalidades

- Ler um número inteiro N representando a quantidade de funcionários.
- Ler os dados dos N funcionários (id, nome e salário).
- Garantir que não haja repetição de id.
- Efetuar o aumento de X por cento no salário de um determinado funcionário.
    - Ler um id e o valor X para o aumento.
    - Se o id informado não existir, mostrar uma mensagem e abortar a operação.
- Mostrar a listagem atualizada dos funcionários ao final.

### Encapsulamento

Para garantir que o salário não possa ser alterado diretamente, é utilizada a técnica de encapsulamento. O salário só pode ser aumentado com base em uma operação de aumento por porcentagem dada.


