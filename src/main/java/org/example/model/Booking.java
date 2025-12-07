package org.example.model;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Guest guest;

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Room room;
    private int nights;

    @Embedded
    @ToString.Exclude
    private MonetaryAmount totalPrice;

    private LocalDate startDate;
    private LocalDate endDate;

    public MonetaryAmount calculateTotalPrice() {
        return new MonetaryAmount(room.getPricePerNight().getAmount() * nights, room.getPricePerNight().getCurrency());
    }
}
