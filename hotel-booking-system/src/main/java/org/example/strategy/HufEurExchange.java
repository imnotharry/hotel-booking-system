package org.example.strategy;

public record HufEurExchange(boolean hufToEur) implements ExchangeStrategy {
    @Override
    public double exchangeCurrency(double amount) {
        return hufToEur ? amount / 383 : amount * 383;
    }
}
