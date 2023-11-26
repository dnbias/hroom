package com.dnbias.hroom.user;

import java.util.Date;

public class Admin extends User {
    public Admin(String username, String password, String name, String surname, Date birthdate,
                 Long userId, String areaOfCompetence) {
        super(username, password, name, surname, birthdate, userId, Capability.ADMIN);
        setAreaOfCompetence(areaOfCompetence);
    }
    private String areaOfCompetence;

    public void banUser(String username, String userID){

    }

    public void allowNewInsertion(String insertionID){

    }



    public void deleteInsertion(){

    }


    public String getAreaOfCompetence() {
        return areaOfCompetence;
    }

    public void setAreaOfCompetence(String areaOfCompetence) {
        this.areaOfCompetence = areaOfCompetence;
    }
}
