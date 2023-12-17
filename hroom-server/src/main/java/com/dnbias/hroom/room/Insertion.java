package com.dnbias.hroom.room;

import com.dnbias.hroom.user.Landlord;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Insertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String features; // TODO cosa intendiamo?
    private String description;
    private double price;
    private String city;
    private String address;
    private List<Long> receivedFeedbacksIds = new ArrayList<>();
    private int area;
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    private String photo; // TODO va sistemata nellla costruzione del codice
    private String name;
    private int meanRating;
    private Long availabilityId;

    public Insertion(String features, String description, double price, String city, String address,
                     List<Long> receivedFeedbacksIds, int area, Landlord landlord, String photo, String name,
                     int meanRating, Long availabilityId, Long insertionID) {
        this.features = features;
        this.description = description;
        this.price = price;
        this.city = city;
        this.address = address;
        this.receivedFeedbacksIds = receivedFeedbacksIds;
        this.area = area;
        this.landlord = landlord;
        this.photo = photo;
        this.name = name;
        this.meanRating = meanRating;
        this.availabilityId = availabilityId;
        this.id = insertionID;
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

    public Long getInsertionID() {
        return id;
    }

    public void setInsertionID(Long insertionID) {
        this.id = insertionID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getReceivedFeedbacksIds() {
        return receivedFeedbacksIds;
    }

    public void setReceivedFeedbacksIds(List<Long> receivedFeedbacksIds) {
        this.receivedFeedbacksIds = receivedFeedbacksIds;
    }

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }
}
