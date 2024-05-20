package com.hroom.feedback.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("1")
@NoArgsConstructor
public class FeedbackOfTenant extends Feedback {
    Long getWriter() {
        return this.getLandlordId();
    }

    Long getSubject() {
        return this.getTenantId();
    }
}
