package com.pnb.eato.Models;

public class MenuItem {

    private Integer itemId;
    private String name;
    private String type;
    private String category;
    private String description;
    private double price;
    private Integer restaurantId;

    public MenuItem(){}

    public MenuItem(Integer itemId, String name, String type, String category, String description, double price, Integer restaurantId) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
