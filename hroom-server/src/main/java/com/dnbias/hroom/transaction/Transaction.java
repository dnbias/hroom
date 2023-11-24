package com.dnbias.hroom.transaction;

import java.util.Random;

public class Transaction {
    private enum paymentType {
        Paypal,
        Mastercard,
        Visa,
        giftCard
    }

    private double paymentAmount;

    private String status;
    public String  checkStatus(String status){
        return status;
    }
    public void ExecuteTransaction(){

    }
}
