package com.pnb.eato.Models;

import java.sql.Date;

public class Rating {

    private String userID;
    private Date date;
    private Integer food;
    private Integer price;
    private Integer staff;
    private String comments;
    private Integer restaurantId;

    public Rating(){}

    public Rating(String userID, Date date, Integer food, Integer price, Integer staff, String comments, Integer restaurantId) {
        this.userID = userID;
        this.date = date;
        this.food = food;
        this.price = price;
        this.staff = staff;
        this.comments = comments;
        this.restaurantId = restaurantId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
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
