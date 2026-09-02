# 005 — Análise de texto com métodos

## Enunciado

Crie um programa em Java que leia uma frase, normalize seus espaços e apresente informações sobre o texto: quantidade de palavras, vogais, dígitos e se a frase pode ser considerada um palíndromo quando espaços e pontuação são ignorados.

## Objetivo

Introduzir manipulação de `String` e decomposição em métodos pequenos, reutilizáveis e testáveis. O exercício também marca a primeira etapa da trilha com uma validação automatizada separada do fluxo interativo.

## Requisitos

1. Ler uma linha completa com `Scanner.nextLine()`.
2. Rejeitar entradas em branco com `String.isBlank()`.
3. Remover espaços nas extremidades e reduzir sequências de espaços em branco internos a um único espaço.
4. Implementar métodos separados para normalização, contagem de palavras, vogais, dígitos e verificação de palíndromo.
5. Considerar vogais sem e com acentuação comum em português.
6. Usar `Locale.ROOT` na conversão para minúsculas para evitar comportamento dependente do locale da máquina.
7. Na verificação de palíndromo, ignorar caracteres que não sejam letras ou dígitos e comparar sem diferenciar maiúsculas de minúsculas.
8. Manter o `main` responsável principalmente por entrada, validação e apresentação do resultado.
9. Incluir testes automatizados simples para os métodos puros, sem adicionar dependências externas neste estágio da trilha.

## Exemplo de entrada

```text
  Java   21 e legal
```

## Exemplo de saída

```text
Texto normalizado: Java 21 e legal
Palavras: 4
Vogais: 5
Digitos: 2
Palindromo: nao
```

## Conceitos praticados

- `String`, `trim()`, `replaceAll()` e `split()`;
- `isBlank()`, `length()` e `charAt()`;
- métodos `static` com responsabilidade específica;
- retorno de valores com `String`, `int` e `boolean`;
- `Character.isDigit()` e `Character.isLetterOrDigit()`;
- comparação case-insensitive com `Character.toLowerCase()`;
- `Locale.ROOT` para transformação de texto determinística;
- laços sobre caracteres;
- dois ponteiros para verificação de palíndromo;
- testes automatizados sem framework externo.

## Abordagem da solução

A entrada é validada no `main` e depois normalizada. A lógica de análise não fica concentrada no fluxo principal: cada operação possui um método próprio. Essa decomposição reduz acoplamento e permite testar as regras sem depender de entrada pelo teclado.

A normalização usa uma expressão regular simples (`\\s+`) para condensar espaços em branco. A contagem de vogais trabalha sobre uma versão em minúsculas criada com `Locale.ROOT`, evitando que o resultado dependa das configurações regionais da JVM.

Para o palíndromo, dois índices percorrem o texto a partir das extremidades. Pontuação e espaços são ignorados; somente letras e dígitos participam da comparação. A abordagem evita criar uma segunda `String` apenas para inverter o texto.

## Validação

Os testes automatizados cobrem:

- normalização de múltiplos espaços e tabulação;
- contagem de palavras, vogais e dígitos;
- vogais acentuadas em `Olá, ação`;
- palíndromos com espaços e pontuação;
- uma frase que não é palíndromo.

Também foi validado manualmente o fluxo interativo com a entrada `Java 21 e legal`.

## Executando

A partir do diretório do exercício:

```bash
javac src/Main.java src/MainTest.java
java -cp src MainTest
java -cp src Main
```

O teste deve encerrar com:

```text
Todos os testes passaram.
```
