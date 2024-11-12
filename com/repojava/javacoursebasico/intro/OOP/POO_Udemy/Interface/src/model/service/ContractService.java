package model.service;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double vallueInstallments = contract.getTotalValue()/months;

        for (int i=1; i<=months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(vallueInstallments, i);
            double fee = onlinePaymentService.paymentFee(vallueInstallments + interest);
            double totalRate = vallueInstallments + fee + interest;

            contract.getInstallments().add(new Installment(dueDate, totalRate));
        }
    }
}
