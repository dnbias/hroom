package com.hroom.insertion.entity;

import java.util.List;

public class Room extends Insertion{
    public Room(Long id,String features, String description, double price, String city, String address,
                List<Long> receivedFeedbacks, int area, Long landlord_id, String photo, String name,
                int meanRating, boolean availability) {
        super(id,features, description, price, city, address, receivedFeedbacks, area, landlord_id, photo, name, meanRating, availability);
    }
}
