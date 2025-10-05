package org.example.dao;

import org.example.datasource.MariaDbConnection;
import org.example.entity.CurrencyRate;

import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    MariaDbConnection connection;
    EntityManager entityManager;

    public CurrencyDao() {
        this.connection = new MariaDbConnection();
        this.entityManager = connection.getInstance();
    }

    public List<CurrencyRate> getAllCurrencies() {
        List<CurrencyRate> currencyRates = entityManager.createQuery("select CurrencyRateToUSD from CurrencyRate CurrencyRateToUSD").getResultList();
        return currencyRates;
    }

    public void addCurrency(String currencyName, double currencyValueToUSD) {
        CurrencyRate currencyRate = new CurrencyRate(currencyName, currencyValueToUSD);
        entityManager.getTransaction().begin();
        entityManager.merge(currencyRate);
        entityManager.getTransaction().commit();
    }
}

