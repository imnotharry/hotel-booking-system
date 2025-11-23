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

    double calculateTotalPrice() {
//        return room.getPricePerNight().getAmount() * nights;
 return 0;   }
}