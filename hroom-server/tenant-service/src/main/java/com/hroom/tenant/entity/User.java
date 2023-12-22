package com.hroom.tenant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/*
 Superclass to have different tables for the children classes.

 A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity
 except that the mappings will apply only to its subclasses since no table exists for the mapped superclass itself.
 When applied to the subclasses the inherited mappings will apply in the context of the subclass tables.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Capability capability;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Date birthdate;

    public enum Capability {
        TENANT,
        LANDLORD,
        ADMIN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthdate=").append(birthdate);
        sb.append(", capability=").append(capability);
        sb.append('}');
        return sb.toString();
    }
}
