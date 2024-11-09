import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Convertendo data-hora global para local");
        System.out.println("---------------------");

        LocalDate data01 = LocalDate.parse("2024-08-03");
        LocalDateTime data02 = LocalDateTime.parse("2024-08-03T18:28:45");
        // Horario de Londes
        Instant data03 = Instant.parse("2024-08-03T02:28:45Z");

        LocalDate dataconvertida01 = LocalDate.ofInstant(data03, ZoneId.systemDefault());

        System.out.println("Data 01: " + data01);
        System.out.println("Data 02: " + data02);
        System.out.println("Data 03: " + dataconvertida01);
        System.out.println("---------------------");
        System.out.println("Dia da data 03: " + data01.getDayOfMonth());
        System.out.println("Mês da data 02: " + data02.getMonth() + ", Mês " + data02.getMonthValue());
        System.out.println("Ano da data 01: " + data01.getYear());
    }
}
