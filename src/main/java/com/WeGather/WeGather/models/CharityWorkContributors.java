package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharityWorkContributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long workedRaiserId;
    private Long userWorkRaiserId;
    private Integer availableContAmount;
    private Integer status;
    private String contributorName;


    public
    CharityWorkContributors() {
    }

    public CharityWorkContributors(Long workedRaiserId, Long userWorkRaiserId, Integer availableContAmount, Integer status, String contributorName) {
        this.workedRaiserId = workedRaiserId;
        this.userWorkRaiserId = userWorkRaiserId;
        this.availableContAmount = availableContAmount;
        this.status = status;
        this.contributorName = contributorName;
    }

    public String getContributorName() {
        return contributorName;
    }

    public void setContributorName(String contributorName) {
        this.contributorName = contributorName;
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

    public Long getWorkedRaiserId() {
        return workedRaiserId;
    }

    public void setWorkedRaiserId(Long workedRaiserId) {
        this.workedRaiserId = workedRaiserId;
    }

    public Long getUserWorkRaiserId() {
        return userWorkRaiserId;
    }

    public void setUserWorkRaiserId(Long userWorkRaiserId) {
        this.userWorkRaiserId = userWorkRaiserId;
    }

    public Integer getAvailableContAmount() {
        return availableContAmount;
    }

    public void setAvailableContAmount(Integer availableContAmount) {
        this.availableContAmount = availableContAmount;
    }
}
