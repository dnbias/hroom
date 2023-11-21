package com.spike.springboot.hroom.demo.user;

import java.util.Date;

public  abstract class User {

    public abstract void  Register(String username, String password, String name, String Surname, Date Birthdate, int userId, typeUser choose) throws IllegalArgumentException;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Date birthdate;
    private int userId;
    public enum typeUser{
        Tenant,
        Admin,
        LandLord
    }

}
