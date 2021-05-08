package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class District {

    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String districtName;


    //    ======= TABLE RELATIONS ===============

    @ManyToOne
    private Governorate governorate;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<Suburb> suburb;

    // ==========ALL CONSTRUCTORS============

    public District() {
    }

    public District(String districtName, Governorate governorate) {
        this.districtName = districtName;
        this.governorate = governorate;
    }
//    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    public Governorate getGovernorate() {
        return governorate;
    }

    public void setGovernorate(Governorate governorate) {
        this.governorate = governorate;
    }

    public List<Suburb> getSuburb() {
        return suburb;
    }

    public void setSuburb(List<Suburb> suburb) {
        this.suburb = suburb;
    }


    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
