package org.example.entity;

import jakarta.persistence.*;

@Entity(name="TransactionTable")
@Table(name="TransactionTable")
public class TransactionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private long identifier;

    @ManyToOne
    @JoinColumn(name="source", referencedColumnName = "CurrencyRateToUSD", nullable = false)
    private CurrencyRate source;

    @ManyToOne
    @JoinColumn(name="destination", referencedColumnName = "CurrencyRateToUSD", nullable=false)
    private CurrencyRate destination;

    @Column(name="amount", nullable=false)
    private double amount;

    // Default constructor needed for JPA
    public TransactionTable() {}

    public TransactionTable(long identifier, CurrencyRate source, CurrencyRate destination, double amount) {
        this.identifier = identifier;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public CurrencyRate getSource() {
        return source;
    }

    public void setSource(CurrencyRate source) {
        this.source = source;
    }

    public CurrencyRate getDestination() {
        return destination;
    }

    public void setDestination(CurrencyRate destination) {
        this.destination = destination;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
