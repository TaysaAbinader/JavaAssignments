package org.example.controller;

import org.example.dao.CurrencyDao;
import org.example.dao.TransactionDao;
import org.example.entity.CurrencyRate;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurrencyController {
    CurrencyDao currencyDao = new CurrencyDao();
    TransactionDao transactionDao = new TransactionDao();

    public CurrencyController() {}

    public List<Currency> getCurrencies() {
        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        List<Currency> currencies = new ArrayList<>();
        for (CurrencyRate rate : rates) {
            currencies.add(Currency.getInstance(rate.getCurrency()));
        }
        return currencies;
    }

    // Behave like a HashMap<Currency, Double>.
    double fromUSDToCurrencyRate(Currency to) {
        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        for (CurrencyRate rate : rates) {
            if (rate.getCurrency().equals(to.getCurrencyCode())) {
                return rate.getRateToUsd();
            }
        }
        throw new IllegalArgumentException("Currency not found");
    }

    public double convertAmount (double amount, Currency from, Currency to) {
        // Special case when from == to.
        if (from == to) {
            return amount;
        }

        Currency usd = Currency.getInstance("USD");
        if (from == usd) {
            return amount * fromUSDToCurrencyRate(to);
        } else if (to == usd) {
            return amount / fromUSDToCurrencyRate(from);
        }

        // E.g. EUR to BRL => (convert EUR to USD) * (convert USD to BRL).
        return (amount / fromUSDToCurrencyRate(from)) * fromUSDToCurrencyRate(to);
    }

    public void addCurrency(String name, String valueToUSD) {
        try {
            Double rateToUSD = Double.parseDouble(valueToUSD);
            currencyDao.addCurrency(name, rateToUSD);
        } catch (NumberFormatException e) {
            System.err.println("Invalid currency value: " + valueToUSD);
        }
    }

    public void addTransaction(Currency source, Currency destination, double amount) {
        CurrencyRate sourceRate = null;
        CurrencyRate destinationRate = null;

        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        for (CurrencyRate rate : rates) {
            if (rate.getCurrency().equals(source.getCurrencyCode())) {
                sourceRate = rate;
            }
            if (rate.getCurrency().equals(destination.getCurrencyCode())) {
                destinationRate = rate;
            }
        }

        transactionDao.addTransaction(sourceRate, destinationRate, amount);
    }
}
