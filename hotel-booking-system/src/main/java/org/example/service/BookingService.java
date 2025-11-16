package org.example.service;

import org.example.model.Guest;
import org.example.model.MonetaryAmount;
import org.example.model.Room;

public class BookingService {

    public static void bookRoom(Room room, Guest guest, int numberOfNights) throws Exception {
        if (room.isAvailable()) {
            double totalPrice = room.getPricePerNight().getAmount() * numberOfNights;
            double totalPriceInHuf = Exchange.exchangeTo(room.getPricePerNight().getCurrency(), guest.getBalance().getCurrency(), totalPrice);

            if (guest.getBalance().getAmount() >= totalPriceInHuf) {
                guest.setBalance(new MonetaryAmount(guest.getBalance().getAmount() - totalPriceInHuf, guest.getBalance().getCurrency()));
                room.setAvailable(false);
                System.out.println(
                        "Guest: " + guest.getName() + "Room: " + room.getRoomNumber() + "Nights: " + numberOfNights);
            } else {
                System.out.println("Not enough money!");
            }
        } else {
            System.out.println("This room is not available!");
        }
    }
}