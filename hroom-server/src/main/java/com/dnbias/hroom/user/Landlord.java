package com.dnbias.hroom.user;

import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.report.Report;
import com.dnbias.hroom.room.Insertion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Landlord extends User{
    private String residence;
    private List<Insertion> insertionOwned = new ArrayList<>();
    private List<Feedback> feedbackMean = new ArrayList<>();
    private int numberOfInsertions;


    private int numberOfRents;

    private List<Report> reports;
    private Map<Tenant, Insertion> reservations;

    public Landlord(String username, String password, String name, String surname, Date birthdate,
                    Long userId, String residence, List<Insertion> insertionOwned, List<Feedback> feedbackMean,
                    int numberOfInsertions, int numberOfRents, List<Report> reports, Map<Tenant, Insertion> reservations) {
        super(username, password, name, surname, birthdate, userId, Capability.TENANT);
        setResidence(residence);
        setInsertionOwned(insertionOwned);
        setFeedbackMean(feedbackMean);
        setNumberOfInsertions(numberOfInsertions);
        setNumberOfRents(numberOfRents);
        setReports(reports);
        setReservations(reservations);
    }


    public void addFeedBack(Tenant tenant, String message){

    }

    public Insertion createInsertion( String features,String Description,String price, String city, String address,String name, String photo)
    {
        return null;
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

    public List<Feedback> getFeedbackMean() {
        return feedbackMean;
    }

    public void setFeedbackMean(List<Feedback> feedbackMean) {
        this.feedbackMean = feedbackMean;
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
