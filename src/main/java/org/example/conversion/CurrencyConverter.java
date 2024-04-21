package org.example.conversion;

import java.util.List;

public class CurrencyConverter {
    private List<CurrencyRate> rates;

    public CurrencyConverter(List<CurrencyRate> rates) {
        this.rates = rates;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = 0.0;
        double toRate = 0.0;

        for (CurrencyRate rate : rates) {
            if (rate.getCurrency().equals(fromCurrency)) {
                fromRate = rate.getRate();
            }
            if (rate.getCurrency().equals(toCurrency)) {
                toRate = rate.getRate();
            }
        }

        if (fromRate == 0.0 || toRate == 0.0) {
            throw new IllegalArgumentException("Currency not supported");
        }

        return amount * (toRate / fromRate);
    }
}

