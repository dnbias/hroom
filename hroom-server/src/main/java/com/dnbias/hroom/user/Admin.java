package com.dnbias.hroom.user;

import java.util.Date;

public class Admin extends User {
    public Admin(String areaOfCompetence) {
        this.areaOfCompetence = areaOfCompetence;
    }
    private String areaOfCompetence;

    public void banUser(String username, String userID){

    }

    public void allowNewRentable(String insertionID){

    }



    public void deleteInsertion(){

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
