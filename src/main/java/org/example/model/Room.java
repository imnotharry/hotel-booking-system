package org.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomNumber;
    private int capacity;

    @Embedded
    private MonetaryAmount pricePerNight;
    private boolean available;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    public Room(long id, String roomNumber, int capacity, MonetaryAmount pricePerNight, boolean available) {
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
