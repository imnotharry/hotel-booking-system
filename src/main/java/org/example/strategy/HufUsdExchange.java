package org.example.strategy;

public record HufUsdExchange(boolean HufToUsd) implements ExchangeStrategy {
    @Override
    public double exchangeCurrency(double amount) {
        return HufToUsd ? amount / 335 : amount * 335;
    }
}
