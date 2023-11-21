package com.spike.springboot.hroom.demo.user;

import java.util.Date;

public class Admin extends User {
    public Admin(String areaOfCompetence) {
        this.areaOfCompetence = areaOfCompetence;
    }
    private String areaOfCompetence;

    public void banUser(String username, String userID){

    }

    public void allowNewRentable(String rentableID){

    }



    public void deleteRentable(){

    }


    @Override
    public void Register(String username, String password, String name, String Surname, Date Birthdate, int userId, typeUser choose) throws IllegalArgumentException {

    }


    public String getAreaOfCompetence() {
        return areaOfCompetence;
    }

    public void setAreaOfCompetence(String areaOfCompetence) {
        this.areaOfCompetence = areaOfCompetence;
    }
}
