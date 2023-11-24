package com.dnbias.hroom.room;

import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.user.Landlord;

import java.util.List;

public class Apartment extends Insertion {
    private int numberOfRooms;



    public Apartment(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, Landlord landLord, String photo, String name, int meanRating, Availability availability, int insertionID) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, availability, insertionID);

    }

    public Apartment(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, Landlord landLord, String photo, String name, int meanRating, Availability availability, int insertionID, int numberOfRooms) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, availability, insertionID);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int  numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
