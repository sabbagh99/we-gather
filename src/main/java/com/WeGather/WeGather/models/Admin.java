package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public
class Admin extends Users {


    // empty constructor
    public
    Admin() {
    }

    // parameterized  constructor

    public
    Admin(String userName, String password, String firstName, String middleName, String lastName, List<String> profilePictures, Date createdAt, String authority ,String email) {
        super(userName,password,firstName,middleName,lastName,profilePictures,createdAt,authority ,email);
    }


}
