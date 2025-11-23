package org.example;

import java.util.List;

import org.example.model.Currency;
import org.example.model.Guest;
import org.example.model.MonetaryAmount;
import org.example.model.Room;
import org.example.service.BookingService;

public class Main {
    public static void main(String[] args) throws Exception {
        Room room = new Room(2, "ABC1", 5, new MonetaryAmount(100, Currency.HUF), true);
        Guest guest = new Guest(4, "Jancsi", 99, new MonetaryAmount(100, Currency.EUR), List.of());

        BookingService.bookRoom(room, guest, 1);

        System.out.println(guest.getBalance());
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
    }
}