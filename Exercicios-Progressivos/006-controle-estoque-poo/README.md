# 006 — Controle de estoque com POO

## Enunciado

Crie um pequeno programa de controle de estoque para um único produto. O produto deve possuir nome, preço unitário e quantidade em estoque, e seu estado deve ser alterado por operações de entrada e saída em vez de acesso direto aos atributos.

## Objetivo

Introduzir orientação a objetos de forma incremental, transformando dados e regras que antes ficariam no `main` em um objeto responsável pelo próprio estado. O foco é praticar classe, objeto, construtor, encapsulamento, métodos de instância e invariantes simples.

## Requisitos

1. Criar uma classe `Produto` separada da classe `Main`.
2. Manter `nome`, `preco` e `quantidade` como atributos privados.
3. Exigir no construtor nome não vazio, preço positivo e quantidade inicial não negativa.
4. Permitir entrada de estoque apenas com quantidade positiva.
5. Permitir saída apenas com quantidade positiva e menor ou igual ao estoque disponível.
6. Não permitir alteração direta da quantidade fora da classe `Produto`.
7. Disponibilizar métodos de consulta para nome, preço, quantidade e valor total em estoque.
8. Fazer o método de saída retornar `boolean` para indicar se a operação foi realizada.
9. Manter o `main` concentrado em entrada, chamada das operações e apresentação do resultado.
10. Incluir testes automatizados simples sem dependências externas.

## Exemplo de entrada

```text
Nome do produto: Teclado
Preco unitario: 120.50
Quantidade inicial: 10
Quantidade para entrada: 3
Quantidade para saida: 5
```

## Exemplo de saída

```text
Produto: Teclado
Preco: R$ 120.50
Quantidade em estoque: 8
Valor total em estoque: R$ 964.00
Saida realizada: sim
```

## Conceitos praticados

- definição e instanciação de classes;
- atributos `private` e encapsulamento;
- construtor e validação de invariantes;
- métodos de instância;
- getters somente para leitura;
- alteração controlada de estado;
- retorno `boolean` para comunicar resultado de uma operação;
- separação entre lógica de domínio e entrada/saída;
- testes sobre comportamento e estado do objeto.

## Abordagem da solução

A classe `Produto` concentra os dados e as regras de estoque. Em vez de o `main` modificar uma variável de quantidade diretamente, ele solicita ao objeto que faça `adicionarEstoque` ou `removerEstoque`. Dessa forma, regras como "não aceitar quantidade negativa" e "não vender acima do estoque" permanecem próximas do estado que protegem.

O construtor impede que um `Produto` seja criado em estado inválido. Para erros de configuração ou argumentos inválidos, a classe lança `IllegalArgumentException`. Já uma tentativa de saída maior que o estoque não é tratada como erro de programação: o método retorna `false` e mantém o estado intacto.

O preço utiliza `double` deliberadamente porque a trilha ainda está consolidando POO básica. Em aplicações financeiras reais, valores monetários normalmente exigem uma representação decimal apropriada, como `BigDecimal`, para evitar problemas de precisão binária. Essa troca será abordada em nível posterior.

## Validação

Os testes cobrem:

- criação válida de produto;
- entrada de estoque;
- saída com estoque suficiente;
- tentativa de saída acima do estoque sem alteração do estado;
- cálculo do valor total em estoque;
- rejeição de nome vazio, preço não positivo e quantidade inicial negativa;
- rejeição de quantidades não positivas nas operações de estoque.

Também deve ser validado manualmente o fluxo interativo apresentado no exemplo.

## Executando

A partir do diretório do exercício:

```bash
javac src/Produto.java src/Main.java src/ProdutoTest.java
java -cp src ProdutoTest
java -cp src Main
```

O teste deve encerrar com:

```text
Todos os testes passaram.
```
