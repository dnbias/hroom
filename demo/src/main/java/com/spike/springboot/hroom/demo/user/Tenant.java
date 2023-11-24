package com.spike.springboot.hroom.demo.user;

import com.spike.springboot.hroom.demo.feedback.Feedback;
import com.spike.springboot.hroom.demo.reservation.Reservation;
import com.spike.springboot.hroom.demo.room.Insertion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Tenant extends User {

    private String residece;
    private List<Insertion> savedInsertions = new ArrayList<>();
    private String preferredPayment;

    private List<Feedback> receivedFeedbacks = new ArrayList<>();
    private HashMap<Reservation,String> reservations ;

    public Tenant(String residece, List<Insertions> savedInsertions, String preferredPayment, List<Feedback> receivedFeedbacks, HashMap<Reservation, String> reservations) {
        this.residece = residece;
        this.savedInsertions = savedInsertions;
        this.preferredPayment = preferredPayment;
        this.receivedFeedbacks = receivedFeedbacks;
        this.reservations = reservations;
    }

    // TODO: 19/11/23
    public void addFeedBack(Insertion, String message)
    {

    }

    public void modifyReservation(String username , Date newDate){

    }

    public void makeTransaction(){

    }

    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId, typeUser choose) throws IllegalArgumentException {

    }

    public String getResidece() {
        return residece;
    }


    public void setResidece(String residece) {
        this.residece = residece;
    }

    public List<Insertion> getSavedInsertions() {
        return savedInsertions;
    }

    public void setSavedInsertions(List<Insertion> savedInsertions) {
        this.savedInsertions = savedInsertions;
    }

    public String getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
    }

    public List<Feedback> getReceivedFeedbacks() {
        return receivedFeedbacks;
    }

    public void setReceivedFeedbacks(List<Feedback> receivedFeedbacks) {
        this.receivedFeedbacks = receivedFeedbacks;
    }

    public HashMap<Reservation, String> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Reservation, String> reservations) {
        this.reservations = reservations;
    }
}
