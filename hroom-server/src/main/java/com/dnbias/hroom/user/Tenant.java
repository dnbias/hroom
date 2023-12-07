package com.dnbias.hroom.user;

import com.dnbias.hroom.feedback.FeedbackOfTenant;
import com.dnbias.hroom.reservation.Reservation;
import com.dnbias.hroom.room.Insertion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Entity
public class Tenant extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String residence;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Insertion> savedInsertions = new ArrayList<>();
    private String preferredPayment;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<FeedbackOfTenant> receivedFeedbacks = new ArrayList<>();
    private HashMap<Reservation,String> reservations ;

    public Tenant(String username, String password, String name, String surname, Date birthdate, Long userId,
                  String residence, List<Insertion> savedInsertions, String preferredPayment,
                  List<FeedbackOfTenant> receivedFeedbacks, HashMap<Reservation, String> reservations) {
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

    public List<FeedbackOfTenant> getReceivedFeedbacks() {
        return receivedFeedbacks;
    }

    public void setReceivedFeedbacks(List<FeedbackOfTenant> receivedFeedbacks) {
        this.receivedFeedbacks = receivedFeedbacks;
    }

    public HashMap<Reservation, String> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Reservation, String> reservations) {
        this.reservations = reservations;
    }
}
