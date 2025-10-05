package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="CurrencyRate")
public class CurrencyRate {

    @Id
    @Column(name="CurrencyRateToUSD", length=3, nullable=false)
    private String currency;

    @Column(name="CurrencyValueToUSD", nullable=false)
    private double rateToUsd;

    // Default constructor needed for JPA
    public CurrencyRate() {}

    public CurrencyRate(String currency, double rateToUsd) {
        if (currency == null) {
            throw new IllegalArgumentException("currency required");
        }
        if (Double.isNaN(rateToUsd)) {
            throw new IllegalArgumentException("rateToUsd must be a valid number");
        }
        this.currency = currency;
        this.rateToUsd = rateToUsd;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRateToUsd() {
        return rateToUsd;
    }

    public void setRateToUsd(double rateToUsd) throws IllegalArgumentException {
        if (rateToUsd < 0) {
            throw new IllegalArgumentException("rateToUsd must be a positive number");
        }
        this.rateToUsd = rateToUsd;
    }
}




