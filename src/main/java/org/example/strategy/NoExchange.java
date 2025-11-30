package org.example.strategy;

public class NoExchange implements ExchangeStrategy{
    @Override
    public double exchangeCurrency(double amount) {
        return amount;
    }
}
