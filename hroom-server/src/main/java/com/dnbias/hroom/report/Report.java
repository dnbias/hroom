package com.dnbias.hroom.report;

public class Report {

    private int reportID;
    private double totalEarnings;
    private int totalHourRented;
    private int numberOfRentals;
    private int numberOfClients;
    private int monthlyEarnings;

    public Report(int reportID, double totalEarnings, int totalHourRented, int numberOfRentals, int numberOfClients, int monthlyEarnings) {
        this.reportID = reportID;
        this.totalEarnings = totalEarnings;
        this.totalHourRented = totalHourRented;
        this.numberOfRentals = numberOfRentals;
        this.numberOfClients = numberOfClients;
        this.monthlyEarnings = monthlyEarnings;
    }

    public void printReport(){

    }
    public void showReport(){

    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public int getTotalHourRented() {
        return totalHourRented;
    }

    public void setTotalHourRented(int totalHourRented) {
        this.totalHourRented = totalHourRented;
    }

    public int getNumberOfRentals() {
        return numberOfRentals;
    }

    public void setNumberOfRentals(int numberOfRentals) {
        this.numberOfRentals = numberOfRentals;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public int getMonthlyEarnings() {
        return monthlyEarnings;
    }

    public void setMonthlyEarnings(int monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }
}
