package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Booking {
    private Guest guest;
    private Room room;
    private int nights;
    private MonetaryAmount totalPrice;

    private LocalDate startDate;
    private LocalDate endDate;

    public double calculateTotalPrice() {
        return room.getPricePerNight().getAmount() * nights;
    }
}
