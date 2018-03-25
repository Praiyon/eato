package com.pnb.eato.Models;

public class Restaurant {

    private Integer restaurantId;
    private String name;
    private String type;
    private String url;

    public Restaurant(){}

    public Restaurant(Integer restaurantId, String name, String type, String url) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
