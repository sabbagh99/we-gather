package com.WeGather.WeGather.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class SystemConfiguration {
    //    ===========All PROPERTY=========
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String branch;
    private String region;
    private String defaultCurrency;
    private String defaultTimeZone;
    private String defaultLanguage;
    private long countryCode;
    private long googleMapKey;
    @ElementCollection
    private List<Long> phoneMassageNumbersService;
    @ElementCollection
    private Set<String> mailingServiceMainEmails;

    // ==========ALL CONSTRUCTORS============
    public SystemConfiguration() {
    }

    public SystemConfiguration(String country, String branch, String region, String defaultCurrency, String defaultTimeZone, String defaultLanguage, long countryCode, long googleMapKey, List<Long> phoneMassageNumbersService, Set<String> mailingServiceMainEmails) {
        this.country = country;
        this.branch = branch;
        this.region = region;
        this.defaultCurrency = defaultCurrency;
        this.defaultTimeZone = defaultTimeZone;
        this.defaultLanguage = defaultLanguage;
        this.countryCode = countryCode;
        this.googleMapKey = googleMapKey;
        this.phoneMassageNumbersService = phoneMassageNumbersService;
        this.mailingServiceMainEmails = mailingServiceMainEmails;
    }

    //    ==========GETTERS AND SETTERS=============


    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public void setDefaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(long countryCode) {
        this.countryCode = countryCode;
    }

    public long getGoogleMapKey() {
        return googleMapKey;
    }

    public void setGoogleMapKey(long googleMapKey) {
        this.googleMapKey = googleMapKey;
    }

    public List<Long> getPhoneMassageNumbersService() {
        return phoneMassageNumbersService;
    }

    public void setPhoneMassageNumbersService(List<Long> phoneMassageNumbersService) {
        this.phoneMassageNumbersService = phoneMassageNumbersService;
    }

    public Set<String> getMailingServiceMainEmails() {
        return mailingServiceMainEmails;
    }

    public void setMailingServiceMainEmails(Set<String> mailingServiceMainEmails) {
        this.mailingServiceMainEmails = mailingServiceMainEmails;
    }


    @Override
    public String toString() {
        return "SystemConfiguration{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", branch='" + branch + '\'' +
                ", region='" + region + '\'' +
                ", defaultCurrency='" + defaultCurrency + '\'' +
                ", defaultTimeZone='" + defaultTimeZone + '\'' +
                ", defaultLanguage='" + defaultLanguage + '\'' +
                ", countryCode=" + countryCode +
                ", googleMapKey=" + googleMapKey +
                ", phoneMassageNumbersService=" + phoneMassageNumbersService +
                ", mailingServiceMainEmails=" + mailingServiceMainEmails +
                '}';
    }
}
