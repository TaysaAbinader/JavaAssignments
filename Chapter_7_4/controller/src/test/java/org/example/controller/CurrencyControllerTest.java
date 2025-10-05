package org.example.controller;

import org.example.entity.CurrencyRate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CurrencyControllerTest {
    private CurrencyController currencyController;

    @BeforeEach
    public void setUp() {
        currencyController = new CurrencyController();
    }

    @Test
    public void testfromUSDToCurrencyRateForUSD() {
        Currency usd = Currency.getInstance("USD");

        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> currencyController.fromUSDToCurrencyRate(usd)
        );

        assertEquals("Currency not found", exception.getMessage());
    }

    @Test
    public void testfromUSDToCurrencyRateForEUR() {
        Currency eur = Currency.getInstance("EUR");
        double value = currencyController.fromUSDToCurrencyRate(eur);
        assertEquals(value, 0.8541);
    }

    @Test
    public void testConvertAmountUSDtoUSD() {
        Currency usd = Currency.getInstance("USD");
        double value = currencyController.convertAmount(1.0, usd, usd);
        assertEquals(value, 1.0);
    }

    @Test
    public void testConvertAmountUSDtoEUR() {
        Currency usd = Currency.getInstance("USD");
        Currency eur = Currency.getInstance("EUR");
        double value = currencyController.convertAmount(1.0, usd, eur);
        assertEquals(value, 0.8541);
    }

    @Test
    public void testConvertAmountEURtoUSD() {
        Currency usd = Currency.getInstance("USD");
        Currency eur = Currency.getInstance("EUR");
        double value = currencyController.convertAmount(1.0, eur, usd);
        assertEquals(value, 1.1708230886313078);
    }
}
