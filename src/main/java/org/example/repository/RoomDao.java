package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.model.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoomDao implements DAO<Room> {

    private final EntityManager entityManager;

    @Override
    public void create(Room room) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(room);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Optional<Room> findById(Long id) {
        Room room = entityManager.find(Room.class, id);
        return Optional.ofNullable(room);
    }

    @Override
    public List<Room> findAll() {
        return entityManager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    @Override
    public void update(Room room) {

        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.merge(room);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}