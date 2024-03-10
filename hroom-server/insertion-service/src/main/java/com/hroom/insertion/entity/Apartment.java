package com.hroom.insertion.entity;

import java.util.List;

public class Apartment extends Insertion {
    private int numberOfRooms;

    public Apartment( Long id,String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Long landlord_id, String photo, String name,
                     int meanRating, boolean availabilityId) {
        super(id,features, description, price, city, address, receivedFeedbacks, area, landlord_id, photo, name, meanRating, availabilityId);
    }

    public Apartment(Long id,String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Long landlord_id, String photo, String name,
                     int meanRating, boolean availability, int numberOfRooms) {
        super(id,features, description, price, city, address, receivedFeedbacks, area, landlord_id, photo, name, meanRating, availability);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int  numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
