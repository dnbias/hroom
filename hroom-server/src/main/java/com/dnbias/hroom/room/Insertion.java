package com.dnbias.hroom.room;

import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.user.Landlord;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Insertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String features; // cosa intendiamo?
    private String description;
    private double price;
    private String city;
    private String address;
    // private List<Feedback> receivedFeedbacks = new ArrayList<>();
    private int area;
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    private String photo; // va sistemata nellla costruzione del codice
    private String name;
    private int meanRating;
    private Availability availability;
    private int insertionID;

    public Insertion(String features, String description, double price, String city, String address,
                     List<Feedback> receivedFeedbacks, int area, Landlord landlord, String photo, String name,
                     int meanRating, Availability availability, int insertionID) {
        this.features = features;
        this.description = description;
        this.price = price;
        this.city = city;
        this.address = address;
        // this.receivedFeedbacks = receivedFeedbacks;
        this.area = area;
        this.landlord = landlord;
        this.photo = photo;
        this.name = name;
        this.meanRating = meanRating;
        this.availability = availability;
        this.insertionID = insertionID;
    }

    public void createAvailability(Availability availability) {

    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // public List<Feedback> getReceivedFeedbacks() {
    //     return receivedFeedbacks;
    // }

    // public void setReceivedFeedbacks(List<Feedback> receivedFeedbacks) {
    //     this.receivedFeedbacks = receivedFeedbacks;
    // }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMeanRating() {
        return meanRating;
    }

    public void setMeanRating(int meanRating) {
        this.meanRating = meanRating;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public int getInsertionID() {
        return insertionID;
    }

    public void setInsertionID(int insertionID) {
        this.insertionID = insertionID;
    }
}
