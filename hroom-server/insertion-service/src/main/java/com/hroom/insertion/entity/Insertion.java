package com.hroom.insertion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

@Entity
@Table(name = "Insertions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Insertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long landlordId;
    @Column(nullable = false)
    private String name;
    private String features; // TODO cosa intendiamo?
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int area;
    private BufferedImage photo;
    private int meanRating;
    private List<Long> receivedFeedbacksIds;
    private Long availabilityId;
}
