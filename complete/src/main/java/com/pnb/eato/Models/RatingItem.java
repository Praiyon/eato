package com.pnb.eato.Models;

import java.sql.Date;

public class RatingItem {
    private Integer userId;
    private String date;
    private Integer itemId;
    private int rating;

    public RatingItem(){}

    public RatingItem(Integer userId, String date, Integer itemId, int rating, String comment) {
        this.userId = userId;
        this.date = date;
        this.itemId = itemId;
        this.rating = rating;
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String comment;
}
