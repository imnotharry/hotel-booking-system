package org.example;

import org.example.model.Currency;
import org.example.model.Guest;
import org.example.model.MonetaryAmount;
import org.example.model.Room;
import org.example.service.BookingService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Room room = new Room(2, "ABC1", 5, new MonetaryAmount(100, Currency.EUR), true);
        Guest guest = new Guest(4, "Jancsi", 99, new MonetaryAmount(100, Currency.USD), List.of());

        BookingService.bookRoom(room, guest, 1);


        System.out.println(guest.getBalance());
    }
}