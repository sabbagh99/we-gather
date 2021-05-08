package com.WeGather.WeGather.models;

import javax.persistence.*;

@Entity
public class UserContactInfo {
    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String address;
    private String governorate;
    private String district;
    private String suburb;

    //    ======= TABLE RELATIONS ===============

    @OneToOne(mappedBy = "userContactInfo")
    private Users user;



    // ==========ALL CONSTRUCTORS============


    public UserContactInfo() {
    }

    public UserContactInfo(String phoneNumber, String address,  String governorate, String district, String suburb) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.governorate = governorate;
        this.district = district;
        this.suburb = suburb;
    }



    //    ==========GETTERS AND SETTERS=============



    public Long getId() {
        return id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserContactInfo{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", governorate='" + governorate + '\'' +
                ", district='" + district + '\'' +
                ", suburb='" + suburb + '\'' +
                '}';
    }
}
