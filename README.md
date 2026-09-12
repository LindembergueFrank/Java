# Java — Estudos e Exercícios

Repositório dedicado ao estudo contínuo de **Java** por meio de exercícios progressivos, soluções documentadas e exemplos executáveis.

O objetivo é registrar a evolução técnica de forma organizada, permitindo acompanhar o avanço desde fundamentos da linguagem até orientação a objetos, Collections, Streams, testes, princípios de engenharia de software e arquitetura.

## 🎯 Escopo da trilha

A coleção progressiva foi desenhada para chegar a aproximadamente **30 exercícios autorais**, priorizando cobertura de conceitos e aumento real de complexidade em vez de quantidade.

Até esse ponto, a meta é consolidar Java suficiente para sustentar desenvolvimento backend profissional. Depois do exercício 030, novos exercícios isolados só devem ser adicionados quando houver uma lacuna técnica concreta identificada durante projetos reais.

A sequência final da trilha deve privilegiar, de forma adaptativa:

- **001–015:** fundamentos, estruturas de controle, arrays, strings, métodos, POO, Collections, Generics, lambdas, Streams, exceções, arquivos, SOLID e padrões iniciais;
- **016–020:** aprofundamento de POO e linguagem, incluindo polimorfismo, `enum`, `record`, `Optional`, `java.time`, `BigDecimal` e modelagem de domínio;
- **021–025:** testes mais estruturados, estruturas de dados, concorrência, `ExecutorService`, sincronização e processamento assíncrono quando justificável;
- **026–030:** refatoração, padrões de projeto aplicados, separação em camadas/portas, pequenos sistemas integradores e um exercício final que combine os principais conceitos da trilha.

Essa divisão é uma referência, não uma obrigação rígida. Um tópico pode ser antecipado, adiado ou substituído quando o estado real do repositório indicar uma progressão melhor.

## 📈 Progressão dos exercícios

Os exercícios são organizados com dificuldade crescente. Cada novo problema deve considerar os conceitos já praticados, evitar repetições e introduzir novos elementos de forma gradual.

### Etapa 1 — Fundamentos

- estrutura básica de um programa Java;
- tipos primitivos e variáveis;
- entrada e saída de dados;
- operadores aritméticos, relacionais e lógicos;
- estruturas condicionais;
- estruturas de repetição.

### Etapa 2 — Resolução de problemas

- arrays e matrizes;
- manipulação de `String`;
- métodos;
- parâmetros e retornos;
- decomposição de problemas;
- algoritmos introdutórios de busca e ordenação.

### Etapa 3 — Orientação a Objetos

- classes e objetos;
- construtores;
- encapsulamento;
- composição;
- herança;
- polimorfismo;
- classes abstratas;
- interfaces.

### Etapa 4 — Java intermediário

- Collections Framework;
- `List`, `Set` e `Map`;
- Generics;
- expressões Lambda;
- Stream API;
- tratamento de exceções;
- leitura e escrita de arquivos.

### Etapa 5 — Qualidade e engenharia de software

- separação de responsabilidades;
- código limpo;
- princípios SOLID;
- testes automatizados;
- refatoração;
- modelagem de domínio;
- padrões de projeto aplicáveis aos exercícios.

### Etapa 6 — Exercícios integradores

- estruturas de dados;
- concorrência e Threads;
- processamento de dados;
- problemas com múltiplas classes e camadas;
- integração de POO, Collections, Streams, exceções e testes;
- decisões introdutórias de arquitetura de software.

## 🌐 Próxima fase — APIs e Spring

Após a consolidação de Java puro, o foco passa a ser desenvolvimento backend com **Spring Boot** e APIs REST. Essa fase será tratada como uma evolução de projetos, não como continuação indefinida de exercícios de sintaxe.

A progressão pretendida é:

1. **API REST básica** — Spring Boot, controllers, services, DTOs e CRUD;
2. **Persistência real** — Spring Data JPA, PostgreSQL, relacionamentos, paginação e Flyway;
3. **Validação e erros** — Bean Validation, regras de negócio e `@ControllerAdvice`;
4. **Testes profissionais** — JUnit 5, Mockito, testes de integração e Testcontainers quando apropriado;
5. **Segurança** — Spring Security, autenticação, autorização por perfis e JWT;
6. **Prontidão operacional** — Docker Compose, OpenAPI/Swagger, Actuator, profiles, logs e configuração por ambiente;
7. **Integrações** — consumo de APIs externas com `WebClient`, timeouts, tratamento de falhas e resiliência;
8. **Projetos maiores** — 2 ou 3 backends completos que demonstrem modelagem, segurança, persistência, testes, documentação e decisões de arquitetura.

A intenção é que a progressão pública do portfólio fique clara: **Java Core → engenharia de software → APIs REST → Spring Boot → backend completo**.

## 📂 Organização dos exercícios

Os exercícios progressivos são organizados em:

```text
Exercicios-Progressivos/
├── 001-nome-do-exercicio/
│   ├── README.md
│   └── src/
│       └── Main.java
├── 002-nome-do-exercicio/
│   ├── README.md
│   └── src/
│       └── Main.java
└── ...
```

Quando a complexidade justificar, um exercício pode possuir múltiplas classes, pacotes, testes ou estrutura de build própria.

Cada diretório deve ser autocontido e conter documentação suficiente para que o problema seja compreendido independentemente da solução.

## 📝 Documentação de cada exercício

Cada exercício deve apresentar, sempre que aplicável:

1. **Enunciado** — descrição objetiva do problema.
2. **Objetivo** — conceito principal praticado.
3. **Requisitos** — regras que a implementação deve atender.
4. **Entrada e saída esperadas** — exemplos de utilização.
5. **Conceitos praticados** — recursos da linguagem utilizados.
6. **Abordagem da solução** — explicação resumida do raciocínio.
7. **Implementação** — código Java completo e executável.
8. **Validação** — casos de teste ou cenários utilizados para conferir a solução.

## 🧭 Princípios dos exercícios

- não repetir problemas já existentes;
- aumentar a dificuldade gradualmente;
- privilegiar soluções legíveis antes de otimizações prematuras;
- utilizar nomes claros para classes, métodos e variáveis;
- evitar responsabilidades excessivas em uma única classe;
- introduzir abstrações somente quando agregarem valor;
- aplicar boas práticas compatíveis com o nível do exercício;
- registrar decisões técnicas relevantes na documentação do próprio exercício;
- encerrar a fase de exercícios isolados quando a base estiver suficientemente consolidada e migrar o esforço para APIs e projetos.

## 🔀 Padrão de commits

Os exercícios utilizam **Conventional Commits** para manter o histórico legível e rastreável.

Exemplos:

```text
feat(exercises): add conditional exercise
feat(exercises): add array statistics exercise
feat(exercises): add object-oriented banking exercise
refactor(exercises): improve domain responsibilities
test(exercises): add validation scenarios
docs: update progressive exercise roadmap
```

Como regra, cada novo exercício deve ser entregue em um **commit atômico**, contendo apenas os arquivos necessários para aquele exercício.

## ☕ Tecnologias e conceitos

- Java
- Programação Orientada a Objetos
- Collections Framework
- Stream API
- Generics
- Exceptions
- Threads e concorrência
- Testes automatizados
- Princípios SOLID
- Design Patterns
- Modelagem e arquitetura de software

## 📚 Exercícios já existentes

O repositório também preserva exercícios produzidos durante estudos anteriores, incluindo conteúdos relacionados a:

- Bootcamp Santander / DIO;
- curso Java completo e POO — Nélio Alves;
- curso de Java — DevDojo;
- outras fontes utilizadas durante os estudos.

Esses conteúdos são mantidos para preservar o histórico de aprendizado.

## 🔗 Referências de estudo

- [BootCamp Santander - DIO](https://app.santanderopenacademy.com/pt-BR/program/santander-bootcamp-2024)
- [Java completo POO + Projetos - Nélio Alves](https://www.udemy.com/course/java-curso-completo/)
- [Curso de Java - DevDojo](https://www.youtube.com/playlist?list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW)

## ▶️ Executando os exercícios

Clone o repositório:

```bash
git clone https://github.com/LindembergueFrank/Java.git
cd Java
```

Entre no diretório do exercício desejado e siga as instruções apresentadas em seu respectivo `README.md`.

Para exercícios simples contendo apenas `Main.java`:

```bash
javac Main.java
java Main
```

Exercícios que utilizarem Maven, Gradle, testes ou outra estrutura terão os comandos específicos documentados em seu próprio diretório.

## 👤 Autor

**Lindembergue Frank**

[LinkedIn](https://www.linkedin.com/in/lindembergue-frank-b991202b7/)

---

`Java` `POO` `Algorithms` `Collections` `Streams` `SOLID` `Design Patterns` `Software Engineering`