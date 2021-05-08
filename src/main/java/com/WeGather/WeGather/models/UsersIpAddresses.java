
package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity

public class UsersIpAddresses {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ElementCollection
    private List<String> ipAddresses;


    @OneToOne(mappedBy = "usersIpAddresses")
    private Users user;


    public UsersIpAddresses() {}

    public UsersIpAddresses(List<String> ipAddresses,Users user){
        this.ipAddresses= ipAddresses;
        this.user=user;

    }

    public
    Users getUsers() {
        return user;
    }

    public
    void setUsers(Users users) {
        this.user = users;
    }

    @ElementCollection
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public long getId() {
        return id;
    }
}

