package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CharityFundContributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long RaisedFundId;
    private Long userFundRaiserId;
    private Integer amountPaid;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Integer status;
    private String donorName;

    public CharityFundContributors() {

    }

    public CharityFundContributors(Long raisedFundId, Long userFundRaiserId, Integer amountPaid, Integer status,String donorName) {
        RaisedFundId = raisedFundId;
        this.userFundRaiserId = userFundRaiserId;
        this.amountPaid = amountPaid;
        this.status = status;
        this.donorName=donorName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getRaisedFundId() {
        return RaisedFundId;
    }

    public void setRaisedFundId(Long raisedFundId) {
        RaisedFundId = raisedFundId;
    }

    public Long getUserFundRaiserId() {
        return userFundRaiserId;
    }

    public void setUserFundRaiserId(Long userFundRaiserId) {
        this.userFundRaiserId = userFundRaiserId;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
