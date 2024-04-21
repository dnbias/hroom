package com.hroom.landlord.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Insertions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long landlord_id;
    private String name;
    private String features; // TODO cosa intendiamo?
    private String description;
    private double price;
    private String city;
    private String address;
    private List<Long> receivedFeedbacksIds = new ArrayList<>();
    private int area;
    private String photo; // TODO va sistemata nellla costruzione del codice
    private int meanRating;
    private Long availabilityId;
}
