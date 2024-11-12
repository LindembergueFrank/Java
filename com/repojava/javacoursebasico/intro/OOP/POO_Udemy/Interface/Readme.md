# Automação de Processamento de Contratos

Uma empresa deseja automatizar o processamento de seus contratos. O processamento de um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no número de meses desejado.

## Contexto

A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas. Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento. Atualmente, o serviço contratado pela empresa é o do Paypal, que aplica juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.

## Objetivo

Desenvolver um programa que leia os dados de um contrato (número do contrato, data do contrato e valor total do contrato). Em seguida, o programa deve ler o número de meses para parcelamento do contrato e, com base nisso, gerar os registros de parcelas a serem pagas (data e valor).

### Regras para geração das parcelas:
- A primeira parcela deverá ser paga um mês após a data do contrato.
- A segunda parcela, dois meses após o contrato, e assim por diante.

O programa deverá exibir os dados das parcelas na tela.

## Exemplo

**Dados do Contrato**:
- Número do Contrato: `1234`
- Data do Contrato: `01/08/2024`
- Valor Total: `R$ 1200,00`
- Número de Meses: `3`

**Parcelas**:
- Parcela 1: `01/09/2024 - R$ 408,00`
- Parcela 2: `01/10/2024 - R$ 412,08`
- Parcela 3: `01/11/2024 - R$ 416,24`
