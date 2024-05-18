package com.hroom.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("landlord")
public class Landlord extends User {
    public Landlord(User u) {
        this.setUsername(u.getUsername());
        this.setPassword(u.getPassword());
        this.setName(u.getName());
        this.setSurname(u.getSurname());
        this.setPhoneNumber(u.getPhoneNumber());
        this.setEmail(u.getEmail());
        this.setCreatedAt(u.getCreatedAt());
    }
}
