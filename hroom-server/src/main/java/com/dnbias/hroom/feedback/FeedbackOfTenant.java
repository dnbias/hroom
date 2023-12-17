package com.dnbias.hroom.feedback;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.dnbias.hroom.user.Landlord;
import com.dnbias.hroom.user.Tenant;

import java.sql.Timestamp;

@Entity
public class FeedbackOfTenant extends Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    public FeedbackOfTenant(Landlord writer, int rating, String description,
                            Timestamp timestamp, Tenant tenant) {
        super(rating, description, timestamp);
        setLandlord(writer);
        setTenant(tenant);
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
