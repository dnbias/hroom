package com.dnbias.hroom.user;

import com.dnbias.hroom.feedback.TargetOfFeedback;
import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.reservation.Reservation;
import com.dnbias.hroom.room.Insertion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Tenant extends User implements TargetOfFeedback {
    private String residence;
    private List<Insertion> savedInsertions = new ArrayList<>();
    private String preferredPayment;
    private List<Feedback> receivedFeedbacks = new ArrayList<>();
    private HashMap<Reservation,String> reservations ;

    public Tenant(String residence, List<Insertion> savedInsertions, String preferredPayment,
                  List<Feedback> receivedFeedbacks, HashMap<Reservation, String> reservations) {
        this.residence = residence;
        this.savedInsertions = savedInsertions;
        this.preferredPayment = preferredPayment;
        this.receivedFeedbacks = receivedFeedbacks;
        this.reservations = reservations;
    }

    // TODO: 19/11/23
    public void addFeedBack(Insertion insertion, int rating, String description)
    {

    }

    public void modifyReservation(String username , Date newDate){

    }

    public void makeTransaction(){

    }

    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId,
                         typeUser choose) throws IllegalArgumentException {

    }

    public String getResidence() {
        return residence;
    }


    public void setResidence(String residence) {
        this.residence = residence;
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
