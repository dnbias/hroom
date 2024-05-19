package com.hroom.feedback.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Feedbacks")
@DiscriminatorColumn(name="subject",
  discriminatorType = DiscriminatorType.INTEGER)
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Long landlordId;
    private Long tenantId;
    private Long insertionId;
    private int rating;
    private String description;
    private String timestamp;

    public Feedback(@Min(0) @Max(5) int rating,
                    String description, String timestamp) {
        this.rating = rating;
        this.description = description;
        this.timestamp = timestamp;
    }

}
