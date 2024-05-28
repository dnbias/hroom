package com.hroom.feedback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Landlord extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    private List<Long> insertionOwnedIds;
    @Column(nullable = false)
    private List<Long> reportsIds;
    @Column(nullable = false)
    private List<Long> reservationsIds;
    @Column(nullable = false)
    private int numberOfInsertions;
    @Column(nullable = false)
    private int numberOfRents;
    @Column(nullable = false)
    private String residence;
}
