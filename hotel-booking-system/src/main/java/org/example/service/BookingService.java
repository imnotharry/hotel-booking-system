package org.example.service;

import org.example.strategy.ExchangeStrategy;
import org.example.strategy.ExchangeStrategyFactory;
import org.example.model.Guest;
import org.example.model.MonetaryAmount;
import org.example.model.Room;

public class BookingService {

    public static void bookRoom(Room room, Guest guest, int numberOfNights) throws Exception {

        if (room.isAvailable()) {
            double totalPrice = room.getPricePerNight().getAmount() * numberOfNights;

            //find the
            ExchangeStrategy exchangeStrategy = ExchangeStrategyFactory.getExchangeStrategy(
                    guest.getBalance().getCurrency(),
                    room.getPricePerNight().getCurrency());

            //get the guest balance in the room currency
            double getGuestBalanceInRoomCurrency = exchangeStrategy.exchangeCurrency(guest.getBalance().getAmount());

            if (getGuestBalanceInRoomCurrency >= totalPrice) {
                //get the amount what will be subtracted from guest balance
                double guestSubtractionAmount = exchangeStrategy.exchangeCurrency(totalPrice);
                guest.setBalance(new MonetaryAmount(guest.getBalance().getAmount() - guestSubtractionAmount, guest.getBalance().getCurrency()));
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