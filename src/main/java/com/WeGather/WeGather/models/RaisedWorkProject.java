package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class RaisedWorkProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startFrom;
    private String endAt;
    @ElementCollection
    private List<String> images;
    private String topic;
    private Integer requiredContAmount;

    @Column(length = 200000)
    private String description;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;


    //============== Relation =================


    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location_id;


    @ManyToOne
    private Users users;

//    @OneToMany(mappedBy = "rasiedWorkFund_id", cascade = CascadeType.ALL)
//    private List<Comments> comments;


    //===================== Constructors ======================
    public RaisedWorkProject() {
    }



    public RaisedWorkProject( String startFrom,
                              String endAt,
                              List<String> images,
                              String topic,
                              Integer requiredContAmount,
                              String description,
                              Location location_id,
                              Users users) {

        this.startFrom = startFrom;
        this.endAt = endAt;
        this.images = images;
        this.topic = topic;
        this.requiredContAmount = requiredContAmount;
        this.description = description;
        this.location_id = location_id;
        this.users = users;
    }

    //================ Getters And Setters =============


    public Long getId() {
        return id;
    }


    public Location getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Location location_id) {
        this.location_id = location_id;
    }
//
//    public List<Comments> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comments> comments) {
//        this.comments = comments;
//    }

    public
    Users getUsers() {
        return users;
    }

    public
    void setUsers(Users users) {
        this.users = users;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(String startFrom) {
        this.startFrom = startFrom;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRequiredContAmount() {
        return requiredContAmount;
    }

    public void setRequiredContAmount(Integer requiredContAmount) {
        this.requiredContAmount = requiredContAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
