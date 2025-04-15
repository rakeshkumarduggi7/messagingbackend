package com.messagingapp.messagingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fromun;
    String toun;

    public requests() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromun() {
        return fromun;
    }

    public void setFromun(String fromun) {
        this.fromun = fromun;
    }

    public String getToun() {
        return toun;
    }

    public void setToun(String toun) {
        this.toun = toun;
    }
}
