package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
