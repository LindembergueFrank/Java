import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public final class Estoque {
    private final Map<String, Integer> saldos = new HashMap<>();

    public synchronized void cadastrar(String produtoId, int quantidadeInicial) {
        String id = validarId(produtoId);
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("A quantidade inicial nao pode ser negativa.");
        }
        if (saldos.containsKey(id)) {
            throw new IllegalArgumentException("Produto ja cadastrado: " + id);
        }
        saldos.put(id, quantidadeInicial);
    }

    public synchronized boolean reservar(String produtoId, int quantidade) {
        String id = validarId(produtoId);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }

        Integer saldo = saldos.get(id);
        if (saldo == null || saldo < quantidade) {
            return false;
        }

        saldos.put(id, saldo - quantidade);
        return true;
    }

    public synchronized OptionalInt saldo(String produtoId) {
        String id = validarId(produtoId);
        Integer saldo = saldos.get(id);
        return saldo == null ? OptionalInt.empty() : OptionalInt.of(saldo);
    }

    private String validarId(String produtoId) {
        if (produtoId == null || produtoId.isBlank()) {
            throw new IllegalArgumentException("O identificador do produto deve ser informado.");
        }
        return produtoId.trim();
    }
}
