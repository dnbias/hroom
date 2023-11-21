package com.spike.springboot.hroom.demo.reservation;

import com.spike.springboot.hroom.demo.check.CheckIn;
import com.spike.springboot.hroom.demo.check.CheckOut;
import com.spike.springboot.hroom.demo.room.Rentable;
import com.spike.springboot.hroom.demo.transaction.Transaction;
import com.spike.springboot.hroom.demo.user.Tenant;

public class Reservation {

   private Transaction transaction;
   private  CheckIn checkIn;
   private CheckOut checkOut;
   private Tenant tenant;
   private Rentable rented;
   private int reservationID;

    public Reservation(Transaction transaction, CheckIn checkIn, CheckOut checkOut, Tenant tenant, Rentable rented, int reservationID) {
        this.transaction = transaction;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tenant = tenant;
        this.rented = rented;
        this.reservationID = reservationID;
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

    public Rentable getRented() {
        return rented;
    }

    public void setRented(Rentable rented) {
        this.rented = rented;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}
