package com.hroom.feedback.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// @Table(name = "")
@DiscriminatorValue("2")
@NoArgsConstructor
public class FeedbackOfInsertion extends Feedback {
    Long getWriter() {
        return this.getTenantId();
    }

    Long getSubject() {
        return this.getInsertionId();
    }
}
