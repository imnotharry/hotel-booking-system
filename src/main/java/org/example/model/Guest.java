package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Guest {
    private int id;
    private String name;
    private int age;
    private MonetaryAmount balance;
    private List<Booking> bookings;
}