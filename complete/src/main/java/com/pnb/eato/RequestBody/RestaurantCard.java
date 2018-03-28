package com.pnb.eato.RequestBody;

public class RestaurantCard {

    private String name;
    private int restaurantId;
    private float foodRating;
    private float priceRating;
    private String picUrl;

    public RestaurantCard(String name, int restaurantId, float foodRating, float priceRating, String picUrl) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.foodRating = foodRating;
        this.priceRating = priceRating;
        this.picUrl = picUrl;
    }

    public RestaurantCard() {
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public float getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(float priceRating) {
        this.priceRating = priceRating;
    }
}
