package com.pnb.eato.Models;

import java.sql.Date;

public class Rating {

    private Integer userID;
    private Date date;
    private double price;
    private double food;
    private double mood;
    private double staff;
    private String comments;
    private Integer restaurantId;

    public Rating(Integer userID, Date date, double price, double food, double mood, double staff, String comments, Integer restaurantId) {
        this.userID = userID;
        this.date = date;
        this.price = price;
        this.food = food;
        this.mood = mood;
        this.staff = staff;
        this.comments = comments;
        this.restaurantId = restaurantId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public Rating(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
