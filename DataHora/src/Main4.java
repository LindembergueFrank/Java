import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("Cálculos com data-hora");
        System.out.println("---------------------");

        LocalDate data01 = LocalDate.parse("2024-01-03");
        LocalDateTime data02 = LocalDateTime.parse("2024-08-03T18:28:45");
        // Horario de Londes
        Instant data03 = Instant.parse("2024-08-03T02:28:45Z");

        LocalDate novaData01 = data01.minusDays(14);
        LocalDateTime novaData02 = data02.plusDays(14);

        System.out.println("Data 01: " + data01);
        System.out.println("Nova data 01: " + novaData01);
        System.out.println("---------------------");
        System.out.println("Data 02: " + data02);
        System.out.println("Nova data 02: " + novaData02);
        System.out.println("---------------------");

        Instant novaData03 = data03.minus(20, ChronoUnit.DAYS);

        //Calculando duração
        Duration duration = Duration.between(novaData01.atStartOfDay(), novaData02);
        System.out.println("Diferenca entre nova data 01 e nova data 02 em dias: " + duration.toDays());
    }
}
