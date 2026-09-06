public class Main {
    public static void main(String[] args) {
        Historico<Evento> historico = new Historico<>(3);

        historico.adicionar(new Evento("Chamado aberto", "Ana"));
        historico.adicionar(new Evento("Tecnico atribuido", "Bruno"));
        historico.adicionar(new Evento("Atendimento iniciado", "Carlos"));
        historico.adicionar(new Evento("Chamado resolvido", "Bruno"));

        System.out.println("Eventos mantidos no historico:");
        for (Evento evento : historico.listar()) {
            System.out.println("- " + evento);
        }

        System.out.println("Ultimo evento: " + historico.ultimo());
    }
}
