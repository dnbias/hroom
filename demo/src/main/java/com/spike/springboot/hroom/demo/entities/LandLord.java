package com.spike.springboot.hroom.demo.entities;

import java.util.ArrayList;

public class LandLord extends User{
    private String residence;
    private List<Rentable> rentableOwned = new ArrayList<>();
    private List<Feedback> feedbackMean = new ArrayList<>();
    private int numberOfInsertions;
    private int numberOfRents;

    private list<Report> report;
    private  Map<Tenant,List<rentableOwned>> mapReservations;
    public void addFeedBack(Tenant tenant, String message){

    }

    public Rentable createRentable( String features,String Description,String price, String city, String address,String name, String photo)
    {
        Rentable Reatable;
        return Reatable;
    }

}
