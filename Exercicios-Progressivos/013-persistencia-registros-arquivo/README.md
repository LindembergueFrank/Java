# 013 — Persistência de registros em arquivo

## Enunciado

Implemente um pequeno repositório de registros capaz de salvar e carregar dados em arquivo texto UTF-8, preservando ordem, validando o formato e tratando falhas de I/O de forma explícita.

## Objetivo

Praticar leitura e escrita de arquivos com `Path` e `Files`, reaproveitando POO, Collections, exceções e testes já vistos sem antecipar ainda SOLID, padrões de projeto ou arquitetura em camadas.

## Requisitos

1. modelar um `Registro` com data/hora e mensagem;
2. persistir registros em arquivo texto UTF-8;
3. usar um formato simples e determinístico, com data/hora e mensagem separadas por tabulação;
4. criar diretórios pais quando necessário;
5. sobrescrever o arquivo de forma completa, sem deixar conteúdo antigo residual;
6. carregar os registros preservando a ordem do arquivo;
7. retornar lista vazia e imutável quando o arquivo ainda não existir;
8. rejeitar mensagens vazias, com tabulação ou quebra de linha;
9. transformar conteúdo malformado em `IOException` com indicação da linha problemática;
10. demonstrar tratamento de `IOException` no `Main`;
11. cobrir comportamento de persistência com testes automatizados usando arquivos temporários.

## Exemplo

Arquivo gerado:

```text
2026-09-10T08:00\tAplicacao iniciada
2026-09-10T08:20\tSincronizacao concluida
```

Ao carregar, os mesmos dois registros devem ser reconstruídos na mesma ordem.

## Conceitos praticados

- `Path` e `Files`;
- `StandardCharsets.UTF_8`;
- `StandardOpenOption`;
- criação de diretórios;
- leitura e escrita de arquivos texto;
- serialização textual simples;
- parsing e validação de formato;
- `IOException` e encadeamento de causa;
- coleções imutáveis;
- testes com diretórios e arquivos temporários;
- limpeza de recursos de teste com `Files.walk`.

## Abordagem da solução

`Registro` representa somente o dado e protege suas invariantes. `RepositorioRegistrosArquivo` concentra a responsabilidade de converter objetos para linhas de texto e reconstruí-los depois.

O formato TSV foi escolhido por ser simples o suficiente para estudar I/O sem introduzir bibliotecas externas. Como consequência, mensagens com tabulação ou quebra de linha são rejeitadas explicitamente.

Na gravação, `CREATE`, `TRUNCATE_EXISTING` e `WRITE` tornam a intenção explícita: criar quando necessário e substituir integralmente o conteúdo anterior. Na leitura, linhas vazias são ignoradas e linhas malformadas geram `IOException` com o número da linha, evitando falha silenciosa.

## Estrutura

```text
013-persistencia-registros-arquivo/
├── README.md
└── src/
    ├── Main.java
    ├── Registro.java
    ├── RepositorioRegistrosArquivo.java
    └── RepositorioRegistrosArquivoTest.java
```

## Validação

```bash
cd Exercicios-Progressivos/013-persistencia-registros-arquivo/src
javac *.java
java RepositorioRegistrosArquivoTest
java Main
```

Resultado esperado dos testes:

```text
Todos os testes passaram.
```

Os testes verificam round-trip de persistência, UTF-8, preservação da ordem, truncamento na sobrescrita, arquivo inexistente, imutabilidade do resultado, erro de parsing com número da linha e validações de entrada.

## Decisões técnicas e trade-offs

`Files.readAllLines` mantém o exercício legível, mas carrega todo o arquivo em memória. Para volumes grandes, leitura por stream ou `BufferedReader` seria mais adequada.

O formato textual não possui escaping: mensagens com tabulações ou quebras de linha são proibidas para manter parsing determinístico. Em uma aplicação real, CSV com biblioteca apropriada, JSON, banco de dados ou outro formato estruturado poderia ser preferível.

Este material representa estudo progressivo e não é apresentado como componente pronto para produção.
