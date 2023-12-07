package com.dnbias.hroom.user;

import com.dnbias.hroom.feedback.FeedbackOfInsertion;
import com.dnbias.hroom.report.Report;
import com.dnbias.hroom.room.Insertion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Entity
public class Landlord extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String residence;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Insertion> insertionOwned;
    private int numberOfInsertions;
    private int numberOfRents;
    private List<Report> reports;
    private Map<Tenant, Insertion> reservations;

    public Landlord(String username, String password, String name, String surname,
                    Date birthdate, Long userId, String residence,
                    List<Insertion> insertionOwned, int numberOfInsertions,
                    int numberOfRents, List<Report> reports,
                    Map<Tenant, Insertion> reservations) {
        super(username, password, name, surname, birthdate, userId, Capability.TENANT);
        setResidence(residence);
        setInsertionOwned(insertionOwned);
        setNumberOfInsertions(numberOfInsertions);
        setNumberOfRents(numberOfRents);
        setReports(reports);
        setReservations(reservations);
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public List<Insertion> getInsertionOwned() {
        return insertionOwned;
    }

    public void setInsertionOwned(List<Insertion> insertionOwned) {
        this.insertionOwned = insertionOwned;
    }

    public int getNumberOfInsertions() {
        return numberOfInsertions;
    }

    public void setNumberOfInsertions(int numberOfInsertions) {
        this.numberOfInsertions = numberOfInsertions;
    }

    public int getNumberOfRents() {
        return numberOfRents;
    }

    public void setNumberOfRents(int numberOfRents) {
        this.numberOfRents = numberOfRents;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> report) {
        this.reports = report;
    }

    public Map<Tenant, Insertion> getReservations() {
        return reservations;
    }

    public void setReservations(Map<Tenant, Insertion > reservations) {
        this.reservations = reservations;
    }
}
