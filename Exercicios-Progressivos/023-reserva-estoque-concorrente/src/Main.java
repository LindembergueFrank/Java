import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Estoque estoque = new Estoque();
        estoque.cadastrar("notebook", 2);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            List<Future<Boolean>> reservas = List.of(
                    executor.submit(() -> estoque.reservar("notebook", 1)),
                    executor.submit(() -> estoque.reservar("notebook", 1)),
                    executor.submit(() -> estoque.reservar("notebook", 1))
            );

            for (Future<Boolean> reserva : reservas) {
                System.out.println("Reserva aceita: " + reserva.get());
            }
            System.out.println("Saldo final: " + estoque.saldo("notebook").orElseThrow());
        } finally {
            executor.shutdown();
        }
    }
}
