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
    private String preferredPayment;
    private List<Long> savedInsertionsIds = new ArrayList<>();
    private List<Long> receivedFeedbacksIds = new ArrayList<>();
    private List<Long> reservationsIds ;

    public Tenant(String username, String password, String name, String surname, Date birthdate, Long userId,
                  String residence, List<Long> savedInsertionsIds, String preferredPayment,
                  List<Long> receivedFeedbacksIds, List<Long> reservationsIds) {
        super(username, password, name, surname, birthdate, userId, Capability.TENANT);
        setResidence(residence);
        setSavedInsertionsIds(savedInsertionsIds);
        setPreferredPayment(preferredPayment);
        setReceivedFeedbacksIds(receivedFeedbacksIds);
        setReservationsIds(reservationsIds);
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }


    public String getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getSavedInsertionsIds() {
        return savedInsertionsIds;
    }

    public void setSavedInsertionsIds(List<Long> savedInsertionsIds) {
        this.savedInsertionsIds = savedInsertionsIds;
    }

    public List<Long> getReceivedFeedbacksIds() {
        return receivedFeedbacksIds;
    }

    public void setReceivedFeedbacksIds(List<Long> receivedFeedbacksIds) {
        this.receivedFeedbacksIds = receivedFeedbacksIds;
    }

    public List<Long> getReservationsIds() {
        return reservationsIds;
    }

    public void setReservationsIds(List<Long> reservationsIds) {
        this.reservationsIds = reservationsIds;
    }

}
