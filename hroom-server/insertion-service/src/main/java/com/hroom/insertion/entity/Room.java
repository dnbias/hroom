package com.hroom.insertion.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rooms")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("1")
public class Room extends Insertion{
}
