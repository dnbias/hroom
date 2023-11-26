package com.dnbias.hroom.user;

import javax.persistence.*;
import java.util.Date;

/*
 Superclass to have different tables for the children classes.

 A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity
 except that the mappings will apply only to its subclasses since no table exists for the mapped superclass itself.
 When applied to the subclasses the inherited mappings will apply in the context of the subclass tables.
 */
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Capability capability;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Date birthdate;
    public enum Capability {
        TENANT,
        LANDLORD,
        ADMIN
    }

    public User(String username, String password, String name, String surname, Date birthdate, Long userId, Capability capability) {
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setBirthdate(birthdate);
        setId(userId);
        setCapability(capability);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
