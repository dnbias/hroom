package com.dnbias.hroom.room;

import com.dnbias.hroom.user.Landlord;

import java.util.List;

public class Apartment extends Insertion {
    private int numberOfRooms;

    public Apartment( Long id,String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Landlord landlord, String photo, String name,
                     int meanRating, boolean availabilityId) {
        super(id,features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availabilityId);
    }

    public Apartment(Long id,String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Landlord landlord, String photo, String name,
                     int meanRating, boolean availability, int numberOfRooms) {
        super(id,features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availability);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int  numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
