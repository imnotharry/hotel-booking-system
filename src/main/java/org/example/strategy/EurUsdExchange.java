package org.example.strategy;

public record EurUsdExchange(boolean EurToUsd) implements ExchangeStrategy {
    @Override
    public double exchangeCurrency(double amount) {
        return EurToUsd ? amount / 0.86 : amount * 1.16;
    }
}
