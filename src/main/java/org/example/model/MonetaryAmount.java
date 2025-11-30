package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MonetaryAmount {
    private double amount;
    private Currency currency;
}
