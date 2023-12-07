package com.dnbias.hroom.room;

import com.dnbias.hroom.user.Landlord;

import java.util.List;

public class Apartment extends Insertion {
    private int numberOfRooms;

    public Apartment(String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Landlord landlord, String photo, String name,
                     int meanRating, Long availabilityId, Long id) {
        super(features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availabilityId, id);
    }

    public Apartment(String features, String description, double price,
                     String city, String address, List<Long> receivedFeedbacks,
                     int area, Landlord landlord, String photo, String name,
                     int meanRating, Long availabilityId, Long id, int numberOfRooms) {
        super(features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availabilityId, id);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int  numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
