package org.example.model;

public class Room {
    private String roomNumber;
    private int capacity;
    private int price;


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
