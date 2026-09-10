import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioRegistrosArquivo {
    public void salvar(Path arquivo, List<Registro> registros) throws IOException {
        validarArquivo(arquivo);
        if (registros == null) {
            throw new IllegalArgumentException("A lista de registros deve ser informada.");
        }

        Path pai = arquivo.toAbsolutePath().getParent();
        if (pai != null) {
            Files.createDirectories(pai);
        }

        List<String> linhas = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro == null) {
                throw new IllegalArgumentException("A lista nao pode conter registro nulo.");
            }
            linhas.add(registro.getDataHora() + "\t" + registro.getMensagem());
        }

        Files.write(
                arquivo,
                linhas,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        );
    }

    public List<Registro> carregar(Path arquivo) throws IOException {
        validarArquivo(arquivo);
        if (Files.notExists(arquivo)) {
            return List.of();
        }

        List<String> linhas = Files.readAllLines(arquivo, StandardCharsets.UTF_8);
        List<Registro> registros = new ArrayList<>();
        for (int indice = 0; indice < linhas.size(); indice++) {
            String linha = linhas.get(indice);
            if (linha.isBlank()) {
                continue;
            }
            registros.add(converterLinha(linha, indice + 1));
        }
        return List.copyOf(registros);
    }

    private Registro converterLinha(String linha, int numeroLinha) throws IOException {
        String[] partes = linha.split("\\t", 2);
        if (partes.length != 2 || partes[1].isBlank()) {
            throw new IOException("Formato invalido na linha " + numeroLinha + ".");
        }
        try {
            return new Registro(LocalDateTime.parse(partes[0]), partes[1]);
        } catch (DateTimeException | IllegalArgumentException erro) {
            throw new IOException("Conteudo invalido na linha " + numeroLinha + ".", erro);
        }
    }

    private void validarArquivo(Path arquivo) {
        if (arquivo == null) {
            throw new IllegalArgumentException("O caminho do arquivo deve ser informado.");
        }
    }
}
