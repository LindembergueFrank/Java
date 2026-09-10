import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class RepositorioRegistrosArquivoTest {
    public static void main(String[] args) throws Exception {
        testarSalvarECarregarMantemDados();
        testarUtf8EOrdem();
        testarSobrescritaTruncaConteudoAnterior();
        testarArquivoAusenteRetornaListaVazia();
        testarLinhaMalformadaFalhaComContexto();
        testarValidacoesDeEntrada();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarSalvarECarregarMantemDados() throws Exception {
        Path diretorio = Files.createTempDirectory("registros-roundtrip-");
        try {
            Path arquivo = diretorio.resolve("dados/registros.tsv");
            RepositorioRegistrosArquivo repositorio = new RepositorioRegistrosArquivo();
            List<Registro> esperado = List.of(
                    new Registro(LocalDateTime.of(2026, 9, 10, 8, 15), "Servidor iniciado"),
                    new Registro(LocalDateTime.of(2026, 9, 10, 9, 30), "Backup concluido")
            );
            repositorio.salvar(arquivo, esperado);
            assertEquals(esperado, repositorio.carregar(arquivo));
        } finally {
            apagarRecursivamente(diretorio);
        }
    }

    private static void testarUtf8EOrdem() throws Exception {
        Path arquivo = Files.createTempFile("registros-utf8-", ".tsv");
        try {
            RepositorioRegistrosArquivo repositorio = new RepositorioRegistrosArquivo();
            List<Registro> registros = List.of(
                    new Registro(LocalDateTime.of(2026, 9, 10, 10, 0), "Conexão restabelecida"),
                    new Registro(LocalDateTime.of(2026, 9, 10, 10, 5), "Usuário autenticado")
            );
            repositorio.salvar(arquivo, registros);
            String conteudo = Files.readString(arquivo, StandardCharsets.UTF_8);
            assertTrue(conteudo.contains("Conexão restabelecida"));
            assertEquals(registros, repositorio.carregar(arquivo));
        } finally {
            Files.deleteIfExists(arquivo);
        }
    }

    private static void testarSobrescritaTruncaConteudoAnterior() throws Exception {
        Path arquivo = Files.createTempFile("registros-truncate-", ".tsv");
        try {
            RepositorioRegistrosArquivo repositorio = new RepositorioRegistrosArquivo();
            repositorio.salvar(arquivo, List.of(
                    new Registro(LocalDateTime.of(2026, 9, 10, 11, 0), "Primeiro"),
                    new Registro(LocalDateTime.of(2026, 9, 10, 11, 1), "Segundo")
            ));
            Registro unico = new Registro(LocalDateTime.of(2026, 9, 10, 11, 2), "Substituto");
            repositorio.salvar(arquivo, List.of(unico));
            assertEquals(List.of(unico), repositorio.carregar(arquivo));
        } finally {
            Files.deleteIfExists(arquivo);
        }
    }

    private static void testarArquivoAusenteRetornaListaVazia() throws Exception {
        Path diretorio = Files.createTempDirectory("registros-ausente-");
        try {
            Path arquivo = diretorio.resolve("inexistente.tsv");
            List<Registro> registros = new RepositorioRegistrosArquivo().carregar(arquivo);
            assertTrue(registros.isEmpty());
            assertThrows(UnsupportedOperationException.class,
                    () -> registros.add(new Registro(LocalDateTime.now(), "Nao permitido")));
        } finally {
            apagarRecursivamente(diretorio);
        }
    }

    private static void testarLinhaMalformadaFalhaComContexto() throws Exception {
        Path arquivo = Files.createTempFile("registros-invalido-", ".tsv");
        try {
            Files.writeString(arquivo, "2026-09-10T12:00\tValido\nlinha-sem-separador\n", StandardCharsets.UTF_8);
            try {
                new RepositorioRegistrosArquivo().carregar(arquivo);
                throw new AssertionError("Era esperada IOException.");
            } catch (IOException erro) {
                assertTrue(erro.getMessage().contains("linha 2"));
            }
        } finally {
            Files.deleteIfExists(arquivo);
        }
    }

    private static void testarValidacoesDeEntrada() {
        RepositorioRegistrosArquivo repositorio = new RepositorioRegistrosArquivo();
        assertThrows(IllegalArgumentException.class, () -> repositorio.salvar(null, List.of()));
        assertThrows(IllegalArgumentException.class, () -> repositorio.salvar(Path.of("arquivo.tsv"), null));
        assertThrows(IllegalArgumentException.class,
                () -> new Registro(LocalDateTime.now(), "linha\nquebrada"));
    }

    private static void apagarRecursivamente(Path caminho) throws IOException {
        if (Files.notExists(caminho)) {
            return;
        }
        try (var caminhos = Files.walk(caminho)) {
            caminhos.sorted((a, b) -> b.compareTo(a)).forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException erro) {
                    throw new RuntimeException(erro);
                }
            });
        }
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (esperado == null ? atual != null : !esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) {
            throw new AssertionError("A condicao deveria ser verdadeira.");
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipoEsperado, AcaoComExcecao acao) {
        try {
            acao.executar();
        } catch (Throwable erro) {
            if (tipoEsperado.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Excecao inesperada: " + erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipoEsperado.getSimpleName());
    }

    @FunctionalInterface
    private interface AcaoComExcecao {
        void executar() throws Exception;
    }
}
