package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.model.Booking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingDao implements DAO<Booking> {

    private final EntityManager entityManager;

    @Override
    public Optional<Booking> findById(Long id) {
        Booking booking = entityManager.find(Booking.class, id);
        return Optional.ofNullable(booking);
    }

    @Override
    public void create(Booking booking) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(booking);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Booking> findAll() {
        return entityManager.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
    }

    @Override
    public void update(Booking booking) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.merge(booking);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
