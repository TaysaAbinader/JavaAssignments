package org.example.entity;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyRateTest {
    @Test
    public void test() throws SQLException {
        Currency currency = Currency.getInstance("GBP");
        CurrencyRate rate = new CurrencyRate(currency.getCurrencyCode(), 0.75);
        assertNotNull(rate);

        assertEquals(rate.getCurrency(), currency);
        assertEquals(rate.getRateToUsd(), 0.75);
    }
}
