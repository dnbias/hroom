package com.dnbias.hroom.room;

import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.user.Landlord;

import java.util.Date;
import java.util.List;

public class Room extends Insertion{
    public Room(String features, String description, double price, String city, String address,
                List<Feedback> receivedFeedbacks, int area, Landlord landlord, String photo, String name,
                int meanRating, Availability availability, int insertionID) {
        super(features, description, price, city, address, receivedFeedbacks, area, landlord, photo, name, meanRating, availability, insertionID);
    }
}
