import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Main1 {
    public static void main(String[] args) {
        DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate data01 = LocalDate.now();
        LocalDateTime data02 = LocalDateTime.now();
        // Horário padrão GMT (Londres)
        Instant data03 = Instant.now();

        // Utilizando datas no padrão ISO 8601
        LocalDate data04 = LocalDate.parse("2024-08-03");
        LocalDateTime data05 = LocalDateTime.parse("2024-08-04T17:37");
        Instant data06 = Instant.parse("2024-08-05T17:37:00Z");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2024-08-06T17:37-03:00");
        Instant data07 = offsetDateTime.toInstant();

        // Datas personalizadas
        LocalDate data08 = LocalDate.parse("03/08/2024", formato01);
        LocalDateTime data09 = LocalDateTime.parse("03/08/2024 17:53", formato02);
        String data08formatada = data08.format(formato01);
        String data09formatada = data09.format(formato02);

        System.out.println("Data 01: " + data01.toString());
        System.out.println("Data 02: " + data02.toString());
        System.out.println("Data 03: " + data03.toString());
        // Implicitamente o toString() já é chamada, não sendo necessario o uso explicíto
        System.out.println("Data 04: " + data04);
        System.out.println("Data 05: " + data05);
        System.out.println("Data 06: " + data06);
        System.out.println("Data 07: " + data07);
        System.out.println("Data 08: " + data08formatada);
        System.out.println("Data 09: " + data09formatada);

    }
}