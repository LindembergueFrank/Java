package application;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato");
        System.out.print("Numero: ");
        int numeroContrato = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), formato);
        System.out.print("Valor do contrato: ");
        double valorContrato = sc.nextDouble();

        Contract contract = new Contract(numeroContrato, data, valorContrato);

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, parcelas);

        System.out.println("Parcelas: ");
        for (Installment installments : contract.getInstallments()) {
            System.out.println(installments);
        }

        sc.close();
    }
}