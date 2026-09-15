# 018 — Carrinho com regras monetárias e invariantes

## Enunciado

Implemente um carrinho de compras que componha produtos e itens, calcule valores monetários com precisão e aplique uma regra de desconto explícita para clientes premium.

## Objetivo

Aprofundar `record`, `enum`, composição, Streams e `BigDecimal` em uma modelagem pequena que se aproxima das regras encontradas em APIs de pedidos e checkout.

## Requisitos

1. representar produtos, itens e resumo financeiro com `record`;
2. modelar a categoria do cliente com `enum`;
3. usar `BigDecimal` em todos os valores monetários;
4. aceitar somente produtos válidos e quantidades positivas;
5. calcular subtotal a partir dos itens, sem armazenar total redundante;
6. aplicar 10% de desconto a clientes premium quando o subtotal for pelo menos R$ 200,00;
7. manter clientes regulares sem desconto;
8. impedir que a coleção interna seja modificada externamente;
9. garantir a consistência `total = subtotal - desconto` no resumo;
10. cobrir limites e invariantes com testes automatizados.

## Exemplo

```text
Subtotal: R$ 270.00
Desconto: R$ 27.00
Total: R$ 243.00
```

## Conceitos praticados

- `record` e construtores compactos;
- `enum` para vocabulário de domínio;
- composição de objetos;
- `BigDecimal`, `setScale` e `RoundingMode`;
- Streams e `reduce`;
- cópia imutável com `List.copyOf`;
- invariantes de domínio;
- testes de valores-limite.

## Abordagem

`Produto` e `ItemCarrinho` são objetos pequenos e imutáveis. O subtotal do item é derivado do preço e da quantidade. `Carrinho` mantém a coleção mutável encapsulada e expõe somente uma cópia não modificável.

`ResumoCarrinho` valida sua própria consistência financeira. Dessa forma, um resumo não pode representar simultaneamente subtotal, desconto e total incompatíveis.

A regra premium fica privada no carrinho porque existe apenas uma variação simples neste estágio. Extrair uma hierarquia de estratégias para uma única regra repetiria o exercício 015 e aumentaria a abstração sem benefício. Se as políticas crescerem, Strategy passa a ser uma refatoração justificável.

## Validação

Requer Java 17 ou superior.

```bash
cd Exercicios-Progressivos/018-carrinho-com-descontos/src
javac *.java
java CarrinhoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes cobrem clientes regulares e premium, o limite exato do desconto, composição de múltiplos itens, coleção exposta como imutável e invariantes inválidas.

## Decisões técnicas e trade-offs

`BigDecimal` é usado no lugar de `double` porque o domínio é monetário. Os valores são arredondados para duas casas com `HALF_UP` no fechamento dos cálculos do carrinho.

A política de desconto está deliberadamente simples e local. Em uma aplicação Spring, regras promocionais poderiam evoluir para serviços ou estratégias injetáveis, enquanto os DTOs permaneceriam separados do modelo de domínio.

O exercício usa testes executáveis sem framework para permanecer coerente com a fase atual. A etapa 021–025 introduzirá uma estratégia de testes mais estruturada.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
