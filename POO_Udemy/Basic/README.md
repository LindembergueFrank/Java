# Exercício 1
## Cálculo de Propriedades de um Retângulo

Este programa lê os valores da largura e altura de um retângulo. Em seguida, calcula e exibe o valor de sua área, perímetro e diagonal. Para isso, utilizamos uma classe específica para realizar os cálculos.

### Fórmulas Utilizadas

Para calcular as propriedades do retângulo, utilizamos as seguintes fórmulas:

- **Área**: = Largura × Altura
- **Perímetro**: = 2 × (Largura + Altura)
- **Diagonal**: = √(Largura² + Altura²)

### Exemplo de Classe

A classe `Rectangle` é responsável por encapsular os valores da largura e altura do retângulo, além de fornecer métodos para calcular a área, perímetro e diagonal.

# Exercício 2
## Gerenciamento de Funcionário

Este programa deve realizar as seguintes operações:

1. Ler os dados de um funcionário, que incluem o nome, o salário bruto e o imposto.
2. Exibir os dados do funcionário, mostrando o nome e o salário líquido.
3. Aplicar um aumento ao salário do funcionário com base em uma porcentagem dada (apenas o salário bruto é afetado pela porcentagem).
4. Exibir novamente os dados do funcionário após o aumento salarial.

## Detalhes da Implementação

### Fórmulas Utilizadas

- **Salário Líquido** = Salário Bruto - Imposto
- **Novo Salário Bruto** após o aumento =
Salário Bruto × (1 + Porcentagem do Aumento)


### Classe Funcionário

A classe `Employee` deve ser projetada para armazenar e manipular os dados do funcionário.

## Exemplo de Uso

1. **Entrada de Dados**:
- Nome: João
- Salário Bruto: 3000.00
- Imposto: 500.00

2. **Saída Inicial**:
- Nome: João
- Salário Líquido: 2500.00

3. **Aplicação de Aumento**:
- Porcentagem do Aumento: 10%

4. **Saída Após Aumento**:
- Nome: João
- Novo Salário Bruto: 3300.00
- Salário Líquido Após Aumento: 2800.00

# Exercicio 3
## Cálculo da Nota Final do Aluno

Este programa deve realizar as seguintes operações:

1. Ler o nome de um aluno e as três notas que ele obteve nos três trimestres do ano.
    - **Nota do Primeiro Trimestre**: vale 30 pontos.
    - **Nota do Segundo Trimestre**: vale 35 pontos.
    - **Nota do Terceiro Trimestre**: vale 35 pontos.

2. Calcular e mostrar a nota final do aluno no ano.

3. Informar se o aluno está aprovado (PASS) ou não (FAILED).
    - A aprovação é obtida com uma nota final igual ou superior a 60% da nota máxima possível (100 pontos).

4. Em caso de reprovação, informar quantos pontos faltam para o aluno atingir o mínimo para ser aprovado.

## Fórmulas Utilizadas

- **Nota Final** = (Nota Primeiro Trimestre × 30/100) + (Nota Segundo Trimestre × 35/100) + (Nota Terceiro Trimestre × 35/100)
- **Nota Mínima para Aprovação** = 60% da Nota Máxima (60 pontos)
- **Pontos Faltantes** = Nota Mínima - Nota Final


### Classe Student

A classe `Student` deve ser projetada para armazenar e manipular os dados do aluno e calcular a nota final.

## Exemplo de Uso

1. **Entrada de Dados**:
- Nome: Ana
- Nota Primeiro Trimestre: 25
- Nota Segundo Trimestre: 30
- Nota Terceiro Trimestre: 32

2. **Cálculo da Nota Final**:

- Nota Final = (25 × 30/100) + (30 × 35/100) + (32 × 35/100)
- Nota Final = 7.5 + 10.5 + 11.2
- Nota Final = 29.2

3. **Resultado**:
- Nome: Ana
- Nota Final: 29.2
- Status: FAILED
- Pontos Faltantes: 60 - 29.2 = 30.8



