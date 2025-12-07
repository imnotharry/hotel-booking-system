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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<Booking> bookings;

    public void addBooking(Booking booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        } else {
            bookings.add(booking);
            booking.setRoom(this);
        }
    }
}
