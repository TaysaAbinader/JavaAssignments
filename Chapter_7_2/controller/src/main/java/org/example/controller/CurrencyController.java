package org.example.controller;

import org.example.dao.CurrencyDao;
import org.example.entity.CurrencyRate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurrencyController {
    CurrencyDao currencyDao = new CurrencyDao();

    public CurrencyController() {}

    public void initialize() throws SQLException {
        currencyDao.initialize();
    }

    public List<Currency> getCurrencies() {
        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        List<Currency> currencies = new ArrayList<>();
        for (CurrencyRate rate : rates) {
            currencies.add(rate.getCurrency());
        }
        return currencies;
    }

    // Behave like a HashMap<Currency, Double>.
    double fromUSDToCurrencyRate(Currency to) {
        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        for (CurrencyRate rate : rates) {
            if (rate.getCurrency().equals(to)) {
                return rate.getRateToUsd();
            }
        }
        throw new IllegalArgumentException("Currency not found");
    }

    public double convertAmount (double amount, Currency from, Currency to) {
        // Special case when from == to.
        if (from == to) {
            return 1.0;
        }

        Currency usd = Currency.getInstance("USD");
        if (from == usd) {
            return fromUSDToCurrencyRate(to);
        } else if (to == usd) {
            return 1.0 / fromUSDToCurrencyRate(from);
        }

        // E.g. EUR to BRL => (convert EUR to USD) * (convert USD to BRL).
        return (1.0 / fromUSDToCurrencyRate(from)) * fromUSDToCurrencyRate(to);
    }
}
