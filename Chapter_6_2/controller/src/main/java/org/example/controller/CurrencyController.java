package org.example.controller;

import org.example.model.CurrencyModel;

public class CurrencyController {
    CurrencyModel currencyModel = new CurrencyModel();

    public CurrencyController() {}

    public double convertAmount (double amount, CurrencyModel.Currency from, CurrencyModel.Currency to) {
        return amount * currencyModel.convert(from, to);
    }
}
