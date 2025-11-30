package org.example.service;

import org.example.model.Room;
import org.example.model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RoomAvailabilityService {

    public List<Room> getAvailableRooms(
            List<Room> rooms,
            LocalDate startDate,
            LocalDate endDate,
            Integer minCapacity,
            Double maxPrice
    ) {

        return rooms.stream()
                .filter(Room::isAvailable)
                .filter(room -> capacityFilter(room, minCapacity))
                .filter(room -> priceFilter(room, maxPrice))
                .filter(room -> isRoomFree(room, startDate, endDate))
                .collect(Collectors.toList());
    }

    private boolean capacityFilter(Room room, Integer minCapacity) {
        return minCapacity == null || room.getCapacity() >= minCapacity;
    }

    private boolean priceFilter(Room room, Double maxPrice) {
        return maxPrice == null || room.getPricePerNight().getAmount() <= maxPrice;
    }

    private boolean isRoomFree(Room room, LocalDate start, LocalDate end) {
        for (Booking booking : room.getBookings()) {
            boolean overlaps =
                    !(end.isBefore(booking.getStartDate()) ||
                      start.isAfter(booking.getEndDate()));

            if (overlaps) return false;
        }
        return true;
    }
}

