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
            double convertGuestBalanceToRoomCurrency = exchangeStrategy.exchangeCurrency(guest.getBalance().getAmount());

            if (convertGuestBalanceToRoomCurrency >= totalPrice) {
                //get the amount what will be subtracted from guest balance
                guest.setBalance(new MonetaryAmount(convertGuestBalanceToRoomCurrency - totalPrice, room.getPricePerNight().getCurrency()));
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