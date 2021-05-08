package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dictionary {
    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String englishWords;
    private String arabicWords;

    // ==========ALL CONSTRUCTORS============

    public Dictionary() {
    }

    public Dictionary(String englishWords, String arabicWords) {
        this.englishWords = englishWords;
        this.arabicWords = arabicWords;
    }
    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getEnglishWords() {
        return englishWords;
    }

    public void setEnglishWords(String englishWords) {
        this.englishWords = englishWords;
    }

    public String getArabicWords() {
        return arabicWords;
    }

    public void setArabicWords(String arabicWords) {
        this.arabicWords = arabicWords;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", englishWords='" + englishWords + '\'' +
                ", arabicWords='" + arabicWords + '\'' +
                '}';
    }
}
