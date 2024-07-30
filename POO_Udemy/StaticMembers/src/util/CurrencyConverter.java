package util;

public class CurrencyConverter {
    public static final double IOF = 0.06;

    private double dolar;
    private double quantityDollars;

    public static double dollarPurchase(double dolar, double quantityDollars) {
        double exchangeRate = IOF * (dolar * quantityDollars);

        return exchangeRate + (dolar * quantityDollars);
    }
}
