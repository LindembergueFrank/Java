import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioRegistrosArquivo repositorio = new RepositorioRegistrosArquivo();
        Path arquivo = Path.of("registros-exemplo.tsv");
        List<Registro> registros = List.of(
                new Registro(LocalDateTime.of(2026, 9, 10, 8, 0), "Aplicacao iniciada"),
                new Registro(LocalDateTime.of(2026, 9, 10, 8, 20), "Sincronizacao concluida")
        );

        try {
            repositorio.salvar(arquivo, registros);
            repositorio.carregar(arquivo).forEach(System.out::println);
        } catch (IOException erro) {
            System.out.println("Falha ao acessar o arquivo: " + erro.getMessage());
        } finally {
            try {
                Files.deleteIfExists(arquivo);
            } catch (IOException ignored) {
                // O exemplo tenta apenas evitar deixar um arquivo gerado no diretorio.
            }
        }
    }
}
