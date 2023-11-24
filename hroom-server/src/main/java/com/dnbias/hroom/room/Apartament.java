package com.dnbias.hroom.room;

import com.spike.springboot.hroom.demo.feedback.Feedback;
import com.spike.springboot.hroom.demo.user.LandLord;

import java.util.Date;
import java.util.List;

public class Apartament extends Inseretion{
    private int numberOfRooms;



    public Apartament(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, LandLord landLord, String photo, String name, int meanRating, Disponibility disponibility, int insertionID) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, disponibility, insertionID);

    }

    public Apartament(String features, String description, double price, String city, String address, List<Feedback> receivedFeedbacks, int area, LandLord landLord, String photo, String name, int meanRating, Disponibility disponibility, int insertionID, int numberOfRooms) {
        super(features, description, price, city, address, receivedFeedbacks, area, landLord, photo, name, meanRating, disponibility, insertionID);
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
