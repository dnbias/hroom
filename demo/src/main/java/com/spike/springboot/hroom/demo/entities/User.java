package com.spike.springboot.hroom.demo.entities;

import java.util.Date;

public interface User {

    public void  Register(String username, String password, String name, String Surname, Date Birthdate, int userId, enum typeUser) Throws IllegalArgumentException;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Date birthdate;
    private int userId;
    private enum typeUser{
        Tenant,
        Admin,
        LandLord
    }

}
