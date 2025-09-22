package org.example.model;

import java.util.HashMap;

public class CurrencyModel {
    public enum Currency {
        USD,
        EUR,
        GBP,
        BRL
    };

    private HashMap<Currency, Double> fromUSDToCurrencyRate = new HashMap<>();

    public CurrencyModel() {
        fromUSDToCurrencyRate.put(Currency.EUR, 0.84);
        fromUSDToCurrencyRate.put(Currency.GBP, 0.74);
        fromUSDToCurrencyRate.put(Currency.BRL, 5.26);
    }

    public double convert(Currency from, Currency to) {
        // Special case when from == to.
        if (from == to) {
            return 1.0;
        }
        if (from == Currency.USD) {
            return fromUSDToCurrencyRate.get(to);
        } else if (to == Currency.USD) {
            return 1.0 / fromUSDToCurrencyRate.get(from);
        }
        // E.g. EUR to BRL => (convert EUR to USD) * (convert USD to BRL).
        return (1.0 / fromUSDToCurrencyRate.get(from)) * fromUSDToCurrencyRate.get(to);
    }
}
                

            

