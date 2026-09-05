# 008 — Catálogo de produtos com Map

## Enunciado

Crie um catálogo de produtos em que cada item possua um código único. O catálogo deve cadastrar produtos, impedir códigos duplicados, localizar e remover itens pelo código e listar os produtos na ordem em que foram cadastrados.

## Objetivo

Evoluir do uso sequencial de `List` para uma coleção associativa. O exercício introduz `Map` quando existe uma necessidade concreta de indexação por chave, reforçando composição, encapsulamento e normalização de dados de entrada.

## Requisitos

1. Criar uma classe `Produto` com código, nome e preço.
2. Validar código e nome não vazios e preço não negativo.
3. Criar uma classe `CatalogoProdutos` que mantenha internamente um `Map<String, Produto>`.
4. Tratar códigos sem diferenciar maiúsculas e minúsculas e ignorar espaços externos.
5. Impedir o cadastro de dois produtos com o mesmo código normalizado.
6. Permitir buscar um produto pelo código.
7. Permitir remover um produto pelo código, informando se a remoção ocorreu.
8. Permitir listar os produtos na ordem de inserção.
9. Não expor a coleção interna mutável diretamente.
10. Manter `Main` responsável apenas pela interação com o usuário e apresentação.
11. Incluir testes automatizados simples sem dependências externas.

## Exemplo de entrada

```text
Quantos produtos deseja cadastrar? 2
Codigo do produto 1: TEC-01
Nome do produto 1: Teclado
Preco do produto 1: 120
Codigo do produto 2: MON-01
Nome do produto 2: Monitor
Preco do produto 2: 900
Codigo para consulta: tec-01
```

## Exemplo de saída

```text
Encontrado: TEC-01 - Teclado - R$ 120.00

Catalogo:
- TEC-01 | Teclado | R$ 120.00
- MON-01 | Monitor | R$ 900.00
```

## Conceitos praticados

- `Map<K, V>`;
- `LinkedHashMap`;
- associação entre chave e objeto;
- `put`, `get`, `remove`, `containsKey` e `values`;
- normalização de chaves;
- composição e encapsulamento de coleção;
- prevenção de duplicidade por chave;
- `List.copyOf` para fornecer um snapshot imutável;
- separação entre entidade, gerenciamento e interface;
- testes de comportamento e invariantes.

## Abordagem da solução

`Produto` representa a entidade e protege suas invariantes básicas. `CatalogoProdutos` usa um `LinkedHashMap` porque o problema possui duas necessidades simultâneas: localizar produtos diretamente pelo código e preservar uma ordem previsível de apresentação.

O código recebido é normalizado com `trim()` e `toUpperCase()` antes de ser usado como chave. Assim, `tec-01`, `TEC-01` e ` TEC-01 ` representam o mesmo identificador lógico e não podem gerar cadastros duplicados.

A escolha de `Map` elimina a necessidade de percorrer todos os produtos para cada consulta por código. Não são introduzidos Streams ou abstrações adicionais nesta etapa, pois o foco é compreender a semântica de uma coleção chave-valor. O preço permanece em `double` apenas para manter continuidade com os exercícios anteriores; aplicações financeiras reais normalmente exigem uma representação decimal apropriada, como `BigDecimal`.

## Validação

Os testes cobrem:

- cadastro e consulta usando chave normalizada;
- rejeição de código duplicado em caixa diferente;
- remoção de produto existente e inexistente;
- preservação da ordem de inserção;
- proteção da lista retornada contra modificação estrutural externa;
- rejeição de código ou nome vazio e preço negativo;
- rejeição de produto nulo.

Também foi validado manualmente um fluxo com dois produtos e consulta case-insensitive.

## Executando

A partir do diretório do exercício:

```bash
javac src/Produto.java src/CatalogoProdutos.java src/Main.java src/CatalogoProdutosTest.java
java -cp src CatalogoProdutosTest
java -cp src Main
```

O teste deve encerrar com:

```text
Todos os testes passaram.
```
