package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Governorate {
    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String governorateName;


    //    ======= TABLE RELATIONS ===============
    @OneToMany(mappedBy = "governorate", cascade = CascadeType.ALL)
    private List<District> district;


    // ==========ALL CONSTRUCTORS============


    public Governorate() {
    }

    public Governorate(String governorateName) {
        this.governorateName = governorateName;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getGovernorateName() {
        return governorateName;
    }

    public void setGovernorateName(String governorateName) {
        this.governorateName = governorateName;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }


    @Override
    public String toString() {
        return "Governorate{" +
                "id=" + id +
                ", governorateName='" + governorateName + '\'' +
                '}';
    }
}
