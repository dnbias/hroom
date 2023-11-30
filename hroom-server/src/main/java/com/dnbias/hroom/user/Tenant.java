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

    public Tenant(String username, String password, String name, String surname, Date birthdate, Long userId,
                  String residence, List<Insertion> savedInsertions, String preferredPayment,
                  List<Feedback> receivedFeedbacks, HashMap<Reservation, String> reservations) {
        super(username, password, name, surname, birthdate, userId, Capability.TENANT);
        setResidence(residence);
        setSavedInsertions(savedInsertions);
        setPreferredPayment(preferredPayment);
        setReceivedFeedbacks(receivedFeedbacks);
        setReservations(reservations);
    }

    // TODO: 19/11/23
    public void addFeedBack(Insertion insertion, int rating, String description)
    {

    }

    public void modifyReservation(String username , Date newDate){

    }

    public void makeTransaction(){

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

    public void saveInsertion(Insertion insertion) {
        if (!savedInsertions.contains(insertion))
            savedInsertions.add(insertion);
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
