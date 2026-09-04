# 007 — Lista de tarefas com Collections

## Enunciado

Crie uma pequena lista de tarefas capaz de cadastrar várias tarefas, localizar uma tarefa pelo título, marcá-la como concluída e listar tanto todas as tarefas quanto apenas as pendentes.

## Objetivo

Avançar da POO aplicada a um único objeto para uma classe que gerencia uma coleção de objetos. O exercício introduz `List` e `ArrayList` em um problema no qual a coleção é necessária para representar múltiplas tarefas, ao mesmo tempo em que reforça composição, encapsulamento e separação de responsabilidades.

## Requisitos

1. Criar uma classe `Tarefa` com título e estado de conclusão.
2. Validar no construtor que o título não seja nulo ou vazio.
3. Não permitir alteração direta do estado da tarefa; a conclusão deve ocorrer por método.
4. Criar uma classe `ListaTarefas` que mantenha internamente uma `List<Tarefa>`.
5. Permitir adicionar tarefas e consultar a quantidade cadastrada.
6. Permitir buscar uma tarefa pelo título sem diferenciar maiúsculas e minúsculas.
7. Permitir concluir uma tarefa pelo título, retornando `boolean` para indicar sucesso.
8. Permitir listar todas as tarefas e apenas as pendentes.
9. Não expor a lista interna mutável diretamente para código externo.
10. Manter `Main` responsável apenas pela interação com o usuário e apresentação.
11. Incluir testes automatizados simples sem dependências externas.

## Exemplo de entrada

```text
Quantas tarefas deseja cadastrar? 3
Titulo da tarefa 1: Estudar Java
Titulo da tarefa 2: Revisar POO
Titulo da tarefa 3: Praticar List
Titulo da tarefa a concluir: Revisar POO
```

## Exemplo de saída

```text
Conclusao realizada: sim

Todas as tarefas:
- [ ] Estudar Java
- [x] Revisar POO
- [ ] Praticar List

Tarefas pendentes:
- [ ] Estudar Java
- [ ] Praticar List
```

## Conceitos praticados

- composição entre objetos;
- `List<T>` e `ArrayList<T>`;
- generics aplicados a Collections;
- laço `for-each` sobre objetos;
- encapsulamento de coleção interna;
- `List.copyOf` para fornecer uma visão imutável dos resultados;
- busca linear em uma coleção;
- separação entre entidade (`Tarefa`), gerenciamento (`ListaTarefas`) e interface (`Main`);
- testes de comportamento e de proteção do estado interno.

## Abordagem da solução

`Tarefa` representa uma única tarefa e protege seu próprio estado. `ListaTarefas` compõe várias instâncias de `Tarefa` por meio de um `ArrayList`, concentrando operações que pertencem ao conjunto, como busca, conclusão e filtragem de pendentes.

Os métodos de listagem não retornam o `ArrayList` interno. Em vez disso, retornam cópias imutáveis com `List.copyOf`, evitando que código externo adicione ou remova elementos da coleção sem passar pelas regras da classe.

A busca é linear porque o objetivo atual é compreender `List` e composição. Estruturas como `Map`, Streams e índices mais eficientes serão introduzidas quando trouxerem ganho claro em exercícios posteriores.

## Validação

Os testes cobrem:

- cadastro e contagem de tarefas;
- busca sem diferenciar maiúsculas e minúsculas;
- conclusão de tarefa existente;
- tentativa de concluir tarefa inexistente;
- filtragem de tarefas pendentes;
- rejeição de título vazio e tarefa nula;
- impossibilidade de modificar externamente a lista retornada.

Também foi validado manualmente o fluxo interativo do exemplo.

## Executando

A partir do diretório do exercício:

```bash
javac src/Tarefa.java src/ListaTarefas.java src/Main.java src/ListaTarefasTest.java
java -cp src ListaTarefasTest
java -cp src Main
```

O teste deve encerrar com:

```text
Todos os testes passaram.
```
