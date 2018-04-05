package com.pnb.eato.Models;

import java.sql.Date;

public class RatingDisplay {
    private Date date;
    private double price;
    private double food;
    private double mood;
    private double staff;
    private String comments;
    private String username;
    private Integer reputation;

    public RatingDisplay() {
    }

    public RatingDisplay(Date date, double price, double food, double mood, double staff, String comments, String username, Integer reputation) {
        this.date = date;
        this.price = price;
        this.food = food;
        this.mood = mood;
        this.staff = staff;
        this.comments = comments;
        this.username = username;
        this.reputation = reputation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getMood() {
        return mood;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public double getStaff() {
        return staff;
    }

    public void setStaff(double staff) {
        this.staff = staff;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }
}
