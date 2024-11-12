package model.service;

public class PaypalService implements OnlinePaymentService{
    private static final double simpleInterest = 0.01;
    private static final double rate = 0.02;

    @Override
    public Double paymentFee(Double amount) {
        return amount * rate;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * months * simpleInterest;
    }
}
