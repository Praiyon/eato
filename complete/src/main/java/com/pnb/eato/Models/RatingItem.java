package com.pnb.eato.Models;

import java.sql.Date;

public class RatingItem {
    private Integer userId;
    private Date date;
    private Integer itemId;
    private int rating;
    private String comment;

    public RatingItem(){}

    public RatingItem(Integer userId, Date date, Integer itemId, int rating, String comment) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

   }
