package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Booking {
    private Guest guest;
    private Room room;
    private int nights;
    private MonetaryAmount totalPrice;

    int calculateTotalPrice() {
        return totalPrice.getAmount() * nights;
    }
}

