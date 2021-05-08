package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fundRaisedId;
    private Long userId;

    //    pickup_type/cash/credit_card
//    https://stackoverflow.com/questions/43391439/integrating-payment-methods-in-db-schemas
    private int pickupType;

    private Long transactionId;
    private Long locationId;

    // ============ Constructors ================
    public Payments() {
    }

//    public Payments(int pickupType) {
//        this.pickupType = pickupType;
//    }

    public Payments(Long fundRaisedId, Long userId, int pickupType, Long transactionId, Long locationId) {
        this.fundRaisedId = fundRaisedId;
        this.userId = userId;
        this.pickupType = pickupType;
        this.transactionId = transactionId;
        this.locationId = locationId;
    }

    //=============== Getter And Setter =================


    public Long getId() {
        return id;
    }


    public Long getFundRaisedId() {
        return fundRaisedId;
    }

    public void setFundRaisedId(Long fundRaisedId) {
        this.fundRaisedId = fundRaisedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPickupType() {
        return pickupType;
    }

    public void setPickupType(int pickupType) {
        this.pickupType = pickupType;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
