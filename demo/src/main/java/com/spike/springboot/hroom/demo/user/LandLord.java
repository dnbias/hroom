package com.spike.springboot.hroom.demo.user;

import com.spike.springboot.hroom.demo.feedback.Feedback;
import com.spike.springboot.hroom.demo.report.Report;
import com.spike.springboot.hroom.demo.room.Rentable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LandLord extends User{
    private String residence;
    private List<Rentable> rentableOwned = new ArrayList<>();
    private List<Feedback> feedbackMean = new ArrayList<>();
    private int numberOfInsertions;


    private int numberOfRents;

    private List<Report> report;
    private Map<Tenant, Rentable> mapReservations;

    public LandLord(String residence, List<Rentable> rentableOwned, List<Feedback> feedbackMean, int numberOfInsertions, int numberOfRents, List<Report> report, Map<Tenant, Rentable> mapReservations) {
        this.residence = residence;
        this.rentableOwned = rentableOwned;
        this.feedbackMean = feedbackMean;
        this.numberOfInsertions = numberOfInsertions;
        this.numberOfRents = numberOfRents;
        this.report = report;
        this.mapReservations = mapReservations;
    }

    public void addFeedBack(Tenant tenant, String message){

    }

    public Rentable createRentable( String features,String Description,String price, String city, String address,String name, String photo)
    {
        Rentable Reatable = null;
        return Reatable;
    }

    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId, typeUser choose) throws IllegalArgumentException {

    }


    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public List<Rentable> getRentableOwned() {
        return rentableOwned;
    }

    public void setRentableOwned(List<Rentable> rentableOwned) {
        this.rentableOwned = rentableOwned;
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

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }

    public Map<Tenant, Rentable> getMapReservations() {
        return mapReservations;
    }

    public void setMapReservations(Map<Tenant, Rentable> mapReservations) {
        this.mapReservations = mapReservations;
    }
}
