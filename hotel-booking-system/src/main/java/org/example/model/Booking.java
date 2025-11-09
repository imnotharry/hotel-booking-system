package org.example.model;

public class Booking {
    private Guest guest;
    private Room room;
    private int nights;
    private MonetaryAmount totalPrice;

    public Booking(Guest guest, Room room, int nights, MonetaryAmount totalPrice) {
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.totalPrice = totalPrice;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public MonetaryAmount getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Booking [Guest: %s, Room: %s, Nights: %d, Total Price: %s]",
                guest.getName(),
                room.getRoomNumber(),
                nights,
                totalPrice
        );
    }

    int calculateTotalPrice() {
        return room.getPrice() * nights;
    }
}

