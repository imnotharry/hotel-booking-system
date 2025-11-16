package org.example.service;

import org.example.model.Currency;

public class Exchange {
    public static double exchangeToHuf(Currency from, double amount) throws Exception {

        double amountInHuf;
        switch (from) {
            case EUR -> amountInHuf = amount * 400;
            case USD -> amountInHuf = amount * 350;
            case HUF -> amountInHuf = amount;

            default -> throw new Exception("Wrong currency");
        }
        return amountInHuf;
    }
}
