package org.example.entity;

import java.util.Currency;

public class CurrencyRate {

    private final Currency currency;
    private final double rateToUsd;

    public CurrencyRate(Currency currency, double rateToUsd) {
        if (currency == null) {
            throw new IllegalArgumentException("currency required");
        }
        if (Double.isNaN(rateToUsd)) {
            throw new IllegalArgumentException("rateToUsd must be a valid number");
        }
        this.currency = currency;
        this.rateToUsd = rateToUsd;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getRateToUsd() {
        return rateToUsd;
    }
}
                

            

