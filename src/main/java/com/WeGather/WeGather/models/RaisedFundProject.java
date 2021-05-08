
package com.WeGather.WeGather.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class RaisedFundProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer requiredAmount;
    private String topic;
    @Column(length = 2000000)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;
    private String startFrom;
    private String endAt;

    @ElementCollection
    private List<String> images;


    //==================== Relation ==================
//    @OneToMany(mappedBy = "rasiedWorkFund_id", cascade = CascadeType.ALL)
//    private List<Comments> comments;

    //    relation between Users & raisedFund
//    @ManyToOne
//    private Users users;

    @ManyToOne
    private Users users;

    public RaisedFundProject() {

    }

    public RaisedFundProject(Integer requiredAmount, String topic, String description,  String strartFrom, String endAt, List<String> images,Users users) {
        this.requiredAmount = requiredAmount;
        this.topic = topic;
        this.description = description;
//        this.createdDate = createdDate;
        this.startFrom = strartFrom;
        this.endAt = endAt;
        this.images = images;
        this.users=users;
    }

    public Long getId() {
        return id;
    }

    public Integer getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(Integer requiredAmount) {
        this.requiredAmount = requiredAmount;
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
//
//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }

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
}
