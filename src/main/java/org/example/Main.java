package org.example;

import org.example.model.Booking;
import org.example.model.Currency;
import org.example.model.Guest;
import org.example.model.MonetaryAmount;
import org.example.model.Room;
import org.example.repository.BookingDao;
import org.example.repository.DAO;
import org.example.repository.GuestDao;
import org.example.repository.HotelEntityManager;
import org.example.repository.RoomDao;

import jakarta.persistence.EntityManager;
import org.example.service.BookingService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        EntityManager entityManager = HotelEntityManager.createEntityManager();

        DAO<Guest> guestDao = new GuestDao(entityManager);
        DAO<Room> roomDao = new RoomDao(entityManager);
        DAO<Booking> bookingDao = new BookingDao(entityManager);

        Guest guest = new Guest(null, "Feri", 10, new MonetaryAmount(100, Currency.EUR), new ArrayList<>());
        guestDao.create(guest);

        Room room = new Room(null, "105A", 6, new MonetaryAmount(10, Currency.HUF), true, new ArrayList<>());
        roomDao.create(room);

        Booking booking = new Booking(null, guest, room, 2, null,
                LocalDate.of(2000, 12, 12),
                LocalDate.of(2000, 12, 15));
        booking.setTotalPrice(booking.calculateTotalPrice());
        bookingDao.create(booking);

        //room.addBooking(booking);
        //guest.addBooking(booking);

        guestDao.update(guest);
        roomDao.update(room);

        BookingService.bookRoom(room, guest, 2);


        System.out.println(guestDao.findAll());
        System.out.println(roomDao.findAll());
        System.out.println(bookingDao.findAll());

        //bookingDao.create(new Booking(null, guest, room, 1, new MonetaryAmount(100, Currency.EUR), null, null));
        //System.out.println(bookingDao.findById(1L).toString());
    }
}