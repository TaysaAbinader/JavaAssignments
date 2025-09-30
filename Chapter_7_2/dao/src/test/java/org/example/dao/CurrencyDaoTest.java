package org.example.dao;

import org.example.entity.CurrencyRate;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyDaoTest {
    @Test
    public void testGetAllCurrencies() {
        CurrencyDao currencyDao = new CurrencyDao();
        List<CurrencyRate> rates = currencyDao.getAllCurrencies();
        assertEquals(rates.size(), 8);
    }
}
