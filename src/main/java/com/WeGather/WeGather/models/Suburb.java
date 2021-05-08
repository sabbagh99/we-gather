package com.WeGather.WeGather.models;

import javax.persistence.*;

@Entity
public class Suburb {

//    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suburbName;



    //    ======= TABLE RELATIONS ===============

    @ManyToOne
    private District district;

    // ==========ALL CONSTRUCTORS============

    public Suburb() {
    }

    public Suburb(String suburbName, District district) {
        this.suburbName = suburbName;
        this.district = district;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }


    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

}
