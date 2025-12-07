package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.model.Guest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GuestDao implements DAO<Guest> {

    private final EntityManager entityManager;

    @Override
    public Optional<Guest> findById(Long id) {
        Guest guest = entityManager.find(Guest.class, id);
        return Optional.ofNullable(guest);
    }

    @Override
    public void create(Guest guest) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(guest);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Guest> findAll() {
        return entityManager.createQuery("SELECT g FROM Guest g", Guest.class).getResultList();
    }

    @Override
    public void update(Guest guest) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.merge(guest);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
