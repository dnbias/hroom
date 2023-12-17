package com.dnbias.hroom.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private Long transactionId;
    private Long checkInId;
    private Long checkOutId;
    private Long tenantId;
    private Long insertionId;

    public Reservation(Long transactionId, Long checkInId, Long checkOutId,
                       Long tenantId, Long insertionId) {
        this.transactionId = transactionId;
        this.checkInId = checkInId;
        this.checkOutId = checkOutId;
        this.tenantId = tenantId;
        this.insertionId = insertionId;
    }

    public Long getInsertionId() {
        return insertionId;
    }

    public void setInsertionId(Long insertionId) {
        this.insertionId = insertionId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransaction(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Long checkInId) {
        this.checkInId = checkInId;
    }

    public Long getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(Long checkOutId) {
        this.checkOutId = checkOutId;
    }
}
