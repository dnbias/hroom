package com.hroom.insertion.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Apartments")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("2")
public class Apartment extends Insertion {
    @Column(nullable = false, columnDefinition = "integer default 1")
    private int numberOfRooms = 2;
}
