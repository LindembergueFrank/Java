import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Quantas tarefas deseja cadastrar? ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (quantidade <= 0) {
                System.out.println("A quantidade deve ser maior que zero.");
                return;
            }

            for (int i = 1; i <= quantidade; i++) {
                System.out.printf("Titulo da tarefa %d: ", i);
                String titulo = scanner.nextLine();
                try {
                    lista.adicionar(new Tarefa(titulo));
                } catch (IllegalArgumentException exception) {
                    System.out.println("Tarefa invalida: " + exception.getMessage());
                    return;
                }
            }

            System.out.print("Titulo da tarefa a concluir: ");
            String titulo = scanner.nextLine();
            boolean concluida = lista.concluir(titulo);

            System.out.printf("Conclusao realizada: %s%n", concluida ? "sim" : "nao");
            imprimir("Todas as tarefas", lista.listarTodas());
            imprimir("Tarefas pendentes", lista.listarPendentes());
        }
    }

    private static void imprimir(String titulo, List<Tarefa> tarefas) {
        System.out.println("\n" + titulo + ":");
        if (tarefas.isEmpty()) {
            System.out.println("- nenhuma");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.printf("- [%s] %s%n", tarefa.isConcluida() ? "x" : " ", tarefa.getTitulo());
        }
    }
}
