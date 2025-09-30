package org.example.dao;

import org.example.entity.CurrencyRate;
import org.example.datasource.MariaDbConnection;

import java.sql.*;
import java.util.*;

public class CurrencyDao {
    Connection connection;

    public void initialize() throws SQLException {
        this.connection = MariaDbConnection.getConnection();
    }

    public List<CurrencyRate> getAllCurrencies() {
        String sql = "SELECT CurrencyRateToUSD, CurrencyValueToUSD FROM CurrencyRate";
        List<CurrencyRate> currencies = new ArrayList<CurrencyRate>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Iterate over SQL results (== rows from the table).
            while (resultSet.next()) {

                Currency currency = Currency.getInstance(resultSet.getString("CurrencyRateToUSD"));
                double rateToUsd = resultSet.getDouble("CurrencyValueToUSD");

                CurrencyRate rate = new CurrencyRate(currency, rateToUsd);
                currencies.add(rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}

