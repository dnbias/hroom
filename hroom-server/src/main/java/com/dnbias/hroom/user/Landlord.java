package com.dnbias.hroom.user
;

import com.dnbias.hroom.feedback.FeedbackOfInsertion;
import com.dnbias.hroom.report.Report;
import com.dnbias.hroom.reservation.Reservation;
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


@Entity
public class Landlord extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private List<Long> insertionOwnedIds;
    private List<Long> reportsIds;
    private List<Long> reservationsIds;
    private int numberOfInsertions;
    private int numberOfRents;
    private String residence;

    public Landlord(String username, String password, String name, String surname,
                    Date birthdate, Long userId, String residence,
                    List<Long> insertionOwnedIds, int numberOfInsertions,
                    int numberOfRents, List<Long> reportsIds,
                    List<Long> reservationsIds) {
        super(username, password, name, surname, birthdate, userId, Capability.TENANT);
        setInsertionOwnedIds(insertionOwnedIds);
        setReportsIds(reportsIds);
        setReservationsIds(reservationsIds);
        setNumberOfInsertions(numberOfInsertions);
        setNumberOfRents(numberOfRents);
        setResidence(residence);
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public List<Long> getInsertionOwnedIds() {
        return insertionOwnedIds;
    }

    public void setInsertionOwnedIds(List<Long> insertionOwnedIds) {
        this.insertionOwnedIds = insertionOwnedIds;
    public ArrayList<Insertion> getInsertions() {
        return insertions;
    }

    public void setInsertions(ArrayList<Insertion> insertionOwned) {
        this.insertions = insertionOwned;
    }

    public float getFeedbackMean() {
        return feedbackMean;
    }

    public void setFeedbackMean(float feedbackMean) {
        this.feedbackMean = feedbackMean;
>>>>>>> efd8d0b (feat: fixes to domain, services and controllers)
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

    public List<Long> getReportsIds() {
        return reportsIds;
    }

    public void setReportsIds(List<Long> reportsIds) {
        this.reportsIds = reportsIds;
    }

    public List<Long> getReservationsIds() {
        return reservationsIds;
    }

    public void setReservationsIds(List<Long> reservationsIds) {
        this.reservationsIds = reservationsIds;
    }
}
