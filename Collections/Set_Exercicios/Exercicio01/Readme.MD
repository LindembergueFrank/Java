# Portal de Cursos Online: Contagem de Alunos por Instrutor

No portal de cursos online, cada usuário possui um código único, representado por um número inteiro.

## Contexto

Cada instrutor do portal pode oferecer vários cursos, e um mesmo aluno pode se matricular em quantos cursos quiser. Dessa forma, o número total de alunos de um instrutor não é simplesmente a soma dos alunos de todos os cursos que ele ministra, pois pode haver alunos matriculados em mais de um curso.

## Objetivo

Desenvolver um programa que leia os códigos dos alunos dos cursos A, B e C ministrados pelo instrutor Alex, e depois exiba a quantidade total de alunos distintos que ele possui.

### Regras para Contagem de Alunos:
- Cada aluno é identificado por um código único.
- O mesmo aluno pode estar matriculado em mais de um curso.
- A contagem total de alunos do instrutor deve considerar apenas alunos distintos.

## Exemplo

**Alunos dos Cursos**:
- Curso A: `21, 35, 22`
- Curso B: `35, 42`
- Curso C: `21, 50, 51`

**Total de Alunos Distintos**: `6`