package com.hroom.feedbacktenant.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Feedback {
    private int rating;
    private String description;
    private Timestamp timestamp;

    public Feedback(@Min(0) @Max(5) int rating,
                    String description, Timestamp timestamp) {
        this.rating = rating;
        this.description = description;
        this.timestamp = timestamp;
    }
}
