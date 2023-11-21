package com.spike.springboot.hroom.demo.room;

import com.spike.springboot.hroom.demo.feedback.Feedback;
import com.spike.springboot.hroom.demo.user.LandLord;

import java.util.Date;
import java.util.List;

public class Apartament extends Rentable{
    private int numberOfRooms;



    public Apartament(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, LandLord landLord, String photo, String name, int meanRating, Disponibility disponibility, int rentableID) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, disponibility, rentableID);

    }

    public Apartament(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, LandLord landLord, String photo, String name, int meanRating, Disponibility disponibility, int rentableID, int numberOfRooms) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, disponibility, rentableID);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int  numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId, typeUser choose) throws IllegalArgumentException {

    }
}
