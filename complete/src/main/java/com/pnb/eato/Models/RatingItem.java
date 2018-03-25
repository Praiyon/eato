package com.pnb.eato.Models;

import java.sql.Date;

public class RatingItem {
    private String userId;
    private Date date;
    private Integer itemId;

    public RatingItem(){}

    public RatingItem(String userId, Date date, Integer itemId, String comment) {
        this.userId = userId;
        this.date = date;
        this.itemId = itemId;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    private String comment;
}
