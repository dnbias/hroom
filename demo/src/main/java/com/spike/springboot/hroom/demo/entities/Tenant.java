package com.spike.springboot.hroom.demo.entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

public class Tenant  implements User{
    private String residece;

    private List<Insertions> savedInsertions = new ArrayList<>();
    private String preferredPayment;

    private List<Feedback> receivedFeedbacks = new ArrayList<>();
    private List<Reservations> reservations = new ArrayList<>();

    // TODO: 19/11/23
    public void addFeedBack(Rentable rentable, String message)
    {

    }

    public void modifyReservation(String username , Date newDate){

    }

    public void makeTransaction(){

    }


    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId) {

    }
}
