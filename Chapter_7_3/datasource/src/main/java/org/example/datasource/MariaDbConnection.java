package org.example.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbConnection {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (entityManager == null) {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory("CurrencyRateMariaDbUnit");
            }
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
