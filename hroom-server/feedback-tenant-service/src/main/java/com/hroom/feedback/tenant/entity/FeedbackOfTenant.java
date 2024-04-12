package com.hroom.feedback.tenant.entity;

import com.hroom.feedback.tenant.entity.Landlord;
import com.hroom.feedback.tenant.entity.Tenant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FeedbacksOfTenant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackOfTenant extends Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Long landlord_id;
    private Long tenant_id;
}
