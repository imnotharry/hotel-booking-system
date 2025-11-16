package org.example.service;

import org.example.model.Currency;

public class Exchange {
    public static double exchangeTo(Currency from, Currency to, double amount) throws Exception {
        double finalAmount = 0;
        if (from == Currency.HUF) {
            switch (to) {
                case EUR -> finalAmount = amount * 400;
                case USD -> finalAmount = amount * 350;
                case HUF -> finalAmount = amount;

                default -> throw new Exception("Wrong currency");
            }
        } else if (from == Currency.EUR) {
            switch (to) {
                case EUR -> finalAmount = amount;
                case USD -> finalAmount = amount * 1.1;
                case HUF -> finalAmount = amount / 400;

                default -> throw new Exception("Wrong currency");
            }
        } else if (from == Currency.USD) {
            switch (to) {
                case USD -> finalAmount = amount;
                case EUR -> finalAmount = amount * 0.9;
                case HUF -> finalAmount = amount / 350;

                default -> throw new Exception("Wrong currency");
            }
        }
        return finalAmount;
    }
}
