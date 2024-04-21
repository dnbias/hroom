package com.hroom.feedback.tenant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tenants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tenant extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String preferredPayment;
    @Column(nullable = false)
    private String residence;
    @Column(nullable = false)
    private List<Long> savedInsertionsIds = new ArrayList<>();
    @Column(nullable = false)
    private List<Long> receivedFeedbacksIds = new ArrayList<>();
    @Column(nullable = false)
    private List<Long> reservationsIds ;

}
