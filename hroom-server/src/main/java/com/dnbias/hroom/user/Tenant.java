package com.dnbias.hroom.user;

import com.dnbias.hroom.reservation.Reservation;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Reservation> reservationsIds ;

    public Tenant(String username, String password, String name, String surname,
                  Date birthdate, String residence, List<Long> savedInsertionsIds,
                  String preferredPayment, List<Long> receivedFeedbacksIds,
                  List<Reservation> reservationsIds) {
        super(username, password, name, surname, birthdate, Capability.TENANT);
        setResidence(residence);
        setSavedInsertionsIds(savedInsertionsIds);
        setPreferredPayment(preferredPayment);
        setReceivedFeedbacksIds(receivedFeedbacksIds);
        setReservationsIds(reservationsIds);
    }

    public Tenant(String username, String password, String name, String surname,
                  Date birthdate, String residence) {
        super(username, password, name, surname, birthdate, Capability.TENANT);
        setResidence(residence);
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

    public List<Reservation> getReservationsIds() {
        return reservationsIds;
    }

    public void setReservationsIds(List<Reservation> reservationsIds) {
        this.reservationsIds = reservationsIds;
    }
}
