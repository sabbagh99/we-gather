
package com.WeGather.WeGather.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

import javax.persistence.*;

@Entity

public class UserConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    private String language;
    private String timeZone;
    private String currency;

    @OneToOne(mappedBy = "userConfiguration")
    private Users user;

    // constructors
    public UserConfiguration(){}

    public UserConfiguration(String language, String timeZone, String currency,Users user) {

        this.language = language;
        this.timeZone = timeZone;
        this.currency = currency;
        this.user=user;
    }





    //getter & setters


    public
    Users getUsers() {
        return user;
    }

    public
    void setUsers(Users users) {
        this.user = users;
    }

    public String getLanguage() {
        return language;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getId() {
        return id;
    }
}