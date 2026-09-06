# 009 — Histórico genérico com limite de capacidade

## Enunciado

Implemente uma estrutura de histórico capaz de armazenar elementos de qualquer tipo com segurança de tipos em tempo de compilação.

O histórico deve possuir uma capacidade máxima definida na criação. Quando um novo item for adicionado e o limite já tiver sido atingido, o elemento mais antigo deve ser descartado antes da inclusão do novo item.

Para demonstrar que a mesma estrutura pode ser reutilizada sem duplicação de código, utilize-a tanto com tipos simples nos testes quanto com objetos `Evento` no programa principal.

## Objetivo

Praticar **Generics em Java** a partir de um problema que realmente se beneficia de uma abstração parametrizada por tipo.

A implementação deve mostrar por que `Historico<T>` é preferível a criar versões separadas como `HistoricoString`, `HistoricoEvento` ou a armazenar tudo como `Object` com casts manuais.

## Requisitos

O exercício deve:

1. criar uma classe genérica `Historico<T>`;
2. receber uma capacidade máxima maior que zero no construtor;
3. rejeitar itens nulos;
4. manter os itens na ordem de inserção;
5. descartar o item mais antigo quando a capacidade for excedida;
6. permitir consultar o último item adicionado;
7. informar o tamanho atual e se o histórico está vazio;
8. retornar uma visão que não permita modificar estruturalmente a coleção interna;
9. demonstrar reutilização com mais de um parâmetro de tipo;
10. manter a classe genérica independente da entidade usada na demonstração.

## Exemplo

Com capacidade igual a `3` e os eventos:

```text
Chamado aberto
Tecnico atribuido
Atendimento iniciado
Chamado resolvido
```

após a quarta inserção o primeiro evento é descartado.

Saída esperada do programa de demonstração:

```text
Eventos mantidos no historico:
- Tecnico atribuido (Bruno)
- Atendimento iniciado (Carlos)
- Chamado resolvido (Bruno)
Ultimo evento: Chamado resolvido (Bruno)
```

## Conceitos praticados

- parâmetros de tipo com `<T>`;
- classes genéricas;
- type inference com operador diamante `<>`;
- segurança de tipos em tempo de compilação;
- reutilização de uma abstração para tipos diferentes;
- `List<T>` e `ArrayList<T>`;
- encapsulamento de coleção;
- `List.copyOf`;
- composição;
- invariantes de construtor;
- testes de comportamento.

## Abordagem da solução

`Historico<T>` não conhece nenhuma regra de domínio de `Evento`. Ele sabe apenas armazenar elementos do tipo escolhido pelo cliente da classe.

Por exemplo:

```java
Historico<String> mensagens = new Historico<>(5);
Historico<Evento> eventos = new Historico<>(10);
```

O compilador impede que um `Evento` seja adicionado a `Historico<String>` e elimina a necessidade de casts ao recuperar elementos. Esse é o principal ganho técnico trabalhado neste exercício.

Internamente é utilizado um `ArrayList<T>` porque a estrutura já é conhecida pelos exercícios anteriores e permite manter o foco em Generics. Quando a capacidade está cheia, `remove(0)` desloca os elementos restantes e possui custo linear. Para um histórico grande ou muito movimentado, uma estrutura como `ArrayDeque` seria mais adequada; essa otimização é deixada para uma etapa futura de estruturas de dados.

O método `ultimo()` retorna `null` quando o histórico está vazio. Essa decisão mantém a API simples neste estágio. Uma evolução posterior pode utilizar `Optional<T>` quando o foco da trilha chegar a APIs mais expressivas para ausência de valor.

`listar()` utiliza `List.copyOf` para impedir que código externo adicione ou remova elementos da coleção interna.

## Estrutura

```text
009-historico-generico/
├── README.md
└── src/
    ├── Evento.java
    ├── Historico.java
    ├── HistoricoTest.java
    └── Main.java
```

## Validação

Compile os arquivos:

```bash
cd Exercicios-Progressivos/009-historico-generico/src
javac *.java
```

Execute os testes:

```bash
java HistoricoTest
```

Resultado esperado:

```text
Todos os testes passaram.
```

Execute a demonstração:

```bash
java Main
```

Os testes verificam:

- uso de `Historico<String>`;
- uso de `Historico<Evento>`;
- uso de `Historico<Integer>` para validar o limite;
- manutenção da ordem dos elementos;
- descarte do item mais antigo ao atingir a capacidade;
- consulta ao último item;
- snapshot estruturalmente imutável;
- rejeição de capacidade inválida;
- rejeição de item nulo;
- invariantes básicas da entidade `Evento`.

## Decisões técnicas

Este exercício não introduz interfaces genéricas, wildcards, limites como `<T extends ...>`, lambdas ou Streams. O objetivo é consolidar primeiro o conceito fundamental de parametrização de tipos e sua aplicação em uma classe reutilizável.

Também não é criada uma abstração de persistência: o histórico existe apenas em memória. O exercício representa estudo progressivo da linguagem, não um componente apresentado como pronto para produção.
