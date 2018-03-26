package com.pnb.eato.Models;

import java.sql.Date;

public class Rater {

    private Integer userId;
    private String email;
    private String name;
    private Date joinDate;
    private Integer rating;
    private String password;
    private String username;
    private Integer reputation;
    private String type;

    public Rater(){}

    public Rater(Integer userId, String email, String name, Date joinDate, String type, String username, String password, Integer reputation) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.joinDate = joinDate;
        this.type = type;
        this.username = username;
        this.password = password;
        this.reputation = reputation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
