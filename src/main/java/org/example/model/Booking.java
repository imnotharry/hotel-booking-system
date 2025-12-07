package org.example.model;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    private int nights;

    @Embedded
    private MonetaryAmount totalPrice;

    private LocalDate startDate;
    private LocalDate endDate;

    public MonetaryAmount calculateTotalPrice() {
        return new MonetaryAmount(room.getPricePerNight().getAmount() * nights, room.getPricePerNight().getCurrency());
    }
}
