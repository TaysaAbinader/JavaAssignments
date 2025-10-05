package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.datasource.MariaDbConnection;
import org.example.entity.CurrencyRate;
import org.example.entity.TransactionTable;

public class TransactionDao {
    EntityManager entityManager;

    public TransactionDao() {
        this.entityManager = MariaDbConnection.getInstance();
    }

    public void addTransaction(CurrencyRate source, CurrencyRate destination, double amount) {
        TransactionTable transaction = new TransactionTable();
        transaction.setSource(source);
        transaction.setDestination(destination);
        transaction.setAmount(amount);

        entityManager.getTransaction().begin();
        entityManager.merge(transaction);
        entityManager.getTransaction().commit();
    }
}

