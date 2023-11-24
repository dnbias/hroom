package com.dnbias.hroom.reservation;

import com.dnbias.hroom.check.CheckIn;
import com.dnbias.hroom.check.CheckOut;
import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.transaction.Transaction;
import com.dnbias.hroom.user.Tenant;

public class Reservation {

   private Transaction transaction;
   private  CheckIn checkIn;
   private CheckOut checkOut;
   private Tenant tenant;
   private Insertion rented;
   private int insertionID;

    public Reservation(Transaction transaction, CheckIn checkIn, CheckOut checkOut, Tenant tenant, Insertion rented, int insertionID) {
        this.transaction = transaction;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tenant = tenant;
        this.rented = rented;
        this.insertionID = insertionID;
    }

    public void addCheckIn(CheckIn checkIn){

   }
   public void addCheckOut(CheckOut checkOut){

    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Insertion getRented() {
        return rented;
    }

    public void setRented(Insertion rented) {
        this.rented = rented;
    }

    public int getInsertionID() {
        return insertionID;
    }

    public void setReservationID(int insertionID) {
        this.insertionID = insertionID;
    }
}
