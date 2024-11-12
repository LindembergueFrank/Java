import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// https://docs.oracle.com/en%2Fjava%2Fjavase%2F17%2Fdocs%2Fapi%2F%2F/java.base/java/time/format/DateTimeFormatter.html

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Convertendo data-hora para texto");
        System.out.println("---------------------");

        LocalDate data01 = LocalDate.parse("2024-08-03");
        LocalDateTime data02 = LocalDateTime.parse("2024-08-03T18:28:45");
        // Horario de Londes
        Instant data03 = Instant.parse("2024-08-03T18:28:45Z");

        DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // Objeto de formatacao para o Instant (UTC)
        DateTimeFormatter formato03 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        DateTimeFormatter formato04 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter formato05 = DateTimeFormatter.ISO_INSTANT;
        
        System.out.println("Data 01: " + data01.format(formato01));
        System.out.println("Data 01: " + formato01.format(data02));
        System.out.println("----------");
        System.out.println("Data 02: " + data02.format(formato02));
        System.out.println("Data 02: " + formato01.format(data02));
        System.out.println("----------");
        // Tem que imprimir o horario local, GMT equivalente
        System.out.println("Data 03: " + formato03.format(data03));
        System.out.println("Data 02: " + formato04.format(data02));
        System.out.println("----------");
        System.out.println("Data 03: " + formato05.format(data03));
    }
}
