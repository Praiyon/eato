package com.pnb.eato.Models;

import java.sql.Date;

public class Rater {

    private String userId;
    private String email;
    private String name;
    private Date joinDate;
    private Integer rating;
    private String password;
    private String username;

    public Rater(){}

    public Rater(String userId, String email, String name, Date joinDate, Integer rating, String username, String password) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.rating = rating;
        this.password = password;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
