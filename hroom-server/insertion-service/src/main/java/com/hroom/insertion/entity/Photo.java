package com.hroom.insertion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Table(name = "Photos")
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(nullable = false, name = "photo", columnDefinition = "MEDIUMBLOB")
    private byte[] data;
}
