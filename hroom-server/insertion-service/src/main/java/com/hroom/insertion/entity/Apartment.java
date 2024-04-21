package com.hroom.insertion.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Apartments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Apartment extends Insertion {
    @Column(nullable = false)
    private int numberOfRooms;
}
