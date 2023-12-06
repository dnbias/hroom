package com.dnbias.hroom.report;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalEarnings;
    private int totalHourRented;
    private int numberOfRentals;
    private int numberOfClients;
    private int monthlyEarnings;

    public Report(Long id, double totalEarnings, int totalHourRented, int numberOfRentals, int numberOfClients, int monthlyEarnings) {
        this.id = id;
        this.totalEarnings = totalEarnings;
        this.totalHourRented = totalHourRented;
        this.numberOfRentals = numberOfRentals;
        this.numberOfClients = numberOfClients;
        this.monthlyEarnings = monthlyEarnings;
    }

    public void printReport(){
        String reportString = generateReport();
        System.out.println(reportString);
    }

    public String generateReport() {
        return String.format("""       
               Report ID : %d
               Total Earnings %.2f
               Total Hours Rented: %d
               Number of Rentals: %d
               Number of Clients: %d
               Monthly Earnings: %d
               """,reportID,totalEarnings,totalHourRented,numberOfRentals,numberOfClients,monthlyEarnings);
    }

    public void showReport(){
        String reportString = generateReport();
        System.out.println(reportString);

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
