package com.dnbias.hroom.feedback;

import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.user.Tenant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class FeedbackOfInsertion extends Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
    @ManyToOne
    @JoinColumn(name = "insertion_id")
    private Insertion insertion;

    public FeedbackOfInsertion(Tenant writer, int rating, String description, Timestamp timestamp, Insertion insertion) {
        super(rating, description, timestamp);
        setInsertion(insertion);
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Insertion getInsertion() {
        return insertion;
    }

    public void setInsertion(Insertion insertion) {
        this.insertion = insertion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
