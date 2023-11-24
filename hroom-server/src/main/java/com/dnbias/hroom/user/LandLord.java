package com.dnbias.hroom.user;

import com.spike.springboot.hroom.demo.feedback.Feedback;
import com.spike.springboot.hroom.demo.report.Report;
import com.spike.springboot.hroom.demo.room.Insertion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LandLord extends User{
    private String residence;
    private List<Inseretion> insertionOwned = new ArrayList<>();
    private List<Feedback> feedbackMean = new ArrayList<>();
    private int numberOfInsertions;


    private int numberOfRents;

    private List<Report> report;
    private Map<Tenant, Insertion> mapReservations;

    public LandLord(String residence, List<Insertion> insertionOwned, List<Feedback> feedbackMean, int numberOfInsertions, int numberOfRents, List<Report> report, Map<Tenant, Insertion> mapReservations) {
        this.residence = residence;
        this.insertionOwned = insertionOwned;
        this.feedbackMean = feedbackMean;
        this.numberOfInsertions = numberOfInsertions;
        this.numberOfRents = numberOfRents;
        this.report = report;
        this.mapReservations = mapReservations;
    }

    public void addFeedBack(Tenant tenant, String message){

    }

    public Insertion createInsertion( String features,String Description,String price, String city, String address,String name, String photo)
    {
        Insertion insertion= null;
        return insertion;
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

    public List<Inseretion> getInsertionOwned() {
        return insertionOwned;
    }

    public void setInsertionOwned(List<Inseretion> insertionOwned) {
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

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }

    public Map<Tenant, Insertion> getMapReservations() {
        return mapReservations;
    }

    public void setMapReservations(Map<Tenant, Insertion > mapReservations) {
        this.mapReservations = mapReservations;
    }
}
