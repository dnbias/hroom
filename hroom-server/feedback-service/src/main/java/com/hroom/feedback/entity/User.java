package com.hroom.feedback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends IdBasedEntity implements Serializable {
    @Column(nullable = false)
    private String username;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String surname;
    @Column (nullable = false)
    private String phoneNumber;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String role;
    @Column
    private LocalDateTime createdAt;

    public enum Capability {
        TENANT,
        LANDLORD,
        ADMIN
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
