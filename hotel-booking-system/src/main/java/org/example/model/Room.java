package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Room {
    private long id;
    private String roomNumber;
    private int capacity;
    private MonetaryAmount pricePerNight;
    private boolean available;

    private List<Booking> bookings = new ArrayList<>();



    public Room(long id,String roomNumber,int capacity,  MonetaryAmount pricePerNight, boolean available) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }


    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}

