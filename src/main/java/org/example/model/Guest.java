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
@Entity
@ToString
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    @Embedded
    private MonetaryAmount balance;

    @OneToMany(mappedBy = "guest",fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public void addBooking(Booking booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        } else {
            bookings.add(booking);
            booking.setGuest(this);
        }
    }
}