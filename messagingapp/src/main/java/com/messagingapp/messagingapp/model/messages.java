package com.messagingapp.messagingapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    String username;
    String reciever;
    @Column(columnDefinition = "TEXT")
    String message;
    LocalDateTime timestamp;

    public messages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
