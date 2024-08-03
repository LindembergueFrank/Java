# Conversor de Moeda

Este programa calcula o valor em reais que uma pessoa pagará ao comprar uma quantia específica em dólares, considerando a cotação do dólar e uma taxa de IOF (Imposto sobre Operações Financeiras) de 6%.

Onde:

- **Cotação do dólar**: é o preço de 1 dólar em reais.
- **Quantidade de dólares**: é a quantia em dólares que a pessoa deseja comprar.
- **Taxa de IOF**: é a alíquota do Imposto sobre Operações Financeiras, que neste caso é de 6% (ou 0,06).

## Exemplo

Considere os seguintes valores de entrada:

- **Cotação do dólar**: 3.10
- **Quantidade de dólares**: 200.00

Portanto, a quantidade de reais a ser paga é 657.20.

## Classe CurrencyConverter

A classe `CurrencyConverter` é responsável pelos cálculos necessários para converter o valor em dólares para reais, aplicando a taxa de IOF.

### Métodos da Classe

- `static double dollarPurchase(double dolar, double quantityDollars)`: Este método recebe a cotação do dólar e a quantidade de dólares a serem comprados, e retorna o valor em reais a ser pago, já incluindo o IOF.

