package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String commenterName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    private String body;
    private Long raisedWorkFundId;

    //    commentType_id(1/2)
    private int commentTypeId;

    //======================= Relation ===================
//    @ManyToOne
//    private RaisedFundProject rasiedWorkFund_id;
//
//    @ManyToOne
//    private RaisedWorkProject rasiedWorkFund_id;


    //================== Constructors =====================
    public Comments() {
    }

//    public Comments(String body) {
//        this.body = body;
//    }

//    public Comments(String body, Long raisedWorkFundId, int commentTypeId) {
//        this.body = body;
//        this.raisedWorkFundId = raisedWorkFundId;
//        this.commentTypeId = commentTypeId;
////        this.raised_Fund_Project_id = raisedFund;
////        this.raisedWork = raisedWorkProject;
//    }
    public Comments(Long userId,String commenterName ,Date createdAt, String body, Long raisedWorkFundId, int commentTypeId) {
        this.userId = userId;
        this.commenterName =  commenterName;
        this.createdAt = createdAt;
        this.body = body;
        this.raisedWorkFundId = raisedWorkFundId;
        this.commentTypeId = commentTypeId;
//        this.raised_Fund_Project_id = raisedFund;
//        this.raisedWork = raisedWorkProject;
    }
    //=============== Getters And Setters =================


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTimeStamp() {
        return createdAt;
    }

    public void setTimeStamp(Date timeStamp) {
        this.createdAt = timeStamp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getRaisedWorkFundId() {
        return raisedWorkFundId;
    }

    public void setRaisedWorkFundId(Long raisedWorkFundId) {
        this.raisedWorkFundId = raisedWorkFundId;
    }

    public int getCommentTypeId() {
        return commentTypeId;
    }

    public void setCommentTypeId(int commentTypeId) {
        this.commentTypeId = commentTypeId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        commenterName = commenterName;
    }

    //    public RaisedFundProject getRaisedFund() {
//        return raised_Fund_Project_id;
//    }
//
//    public void setRaisedFund(RaisedFundProject raisedFund) {
//        this.raised_Fund_Project_id = raisedFund;
//    }
//
//    public RaisedWorkProject getRaisedWork() {
//        return raisedWork;
//    }
//
//    public void setRaisedWork(RaisedWorkProject raisedWork) {
//        this.raisedWork = raisedWork;
//    }
}
