package com.WeGather.WeGather.models;

import javax.persistence.*;

@Entity
public class Location {
//    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longitude;
    private String latitude;
    private String description;
    private Long governorate_id;
    private Long district_id;
    private Long suburb_id;

    // ================== Relation =================

    @OneToOne(mappedBy = "location_id",cascade = CascadeType.ALL)
    private RaisedWorkProject raisedWorkProject;
    // ==========ALL CONSTRUCTORS============

    public Location() {
    }
    public Location(String longitude, String latitude, String description) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.governorate_id = null;
        this.district_id = null;
        this.suburb_id = null;
    }

//    public Location(long longitude, long latitude, String description, Long governorate_id, Long district_id, Long suburb_id) {
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.description = description;
//        this.governorate_id = governorate_id;
//        this.district_id = district_id;
//        this.suburb_id = suburb_id;
//    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGovernorate_id() {
        return governorate_id;
    }

    public void setGovernorate_id(Long governorate_id) {
        this.governorate_id = governorate_id;
    }

    public Long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Long district_id) {
        this.district_id = district_id;
    }

    public Long getSuburb_id() {
        return suburb_id;
    }

    public void setSuburb_id(Long suburb_id) {
        this.suburb_id = suburb_id;
    }

    public RaisedWorkProject getRaisedWorkProject() {
        return raisedWorkProject;
    }

    public void setRaisedWorkProject(RaisedWorkProject raisedWorkProject) {
        this.raisedWorkProject = raisedWorkProject;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
                ", governorate_id=" + governorate_id +
                ", district_id=" + district_id +
                ", suburb_id=" + suburb_id +
                '}';
    }
}
