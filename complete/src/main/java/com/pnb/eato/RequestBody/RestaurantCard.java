package com.pnb.eato.RequestBody;

public class RestaurantCard {

    private String name;
    private int restaurantId;
    private float foodRating;
    private float priceRating;
    private float moodRating;
    private float staffRating;
    private String picUrl;
    private String logoUrl;

    public RestaurantCard(String name, int restaurantId, float foodRating, float priceRating, float moodRating, float staffRating, String picUrl, String logoUrl) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.foodRating = foodRating;
        this.priceRating = priceRating;
        this.moodRating = moodRating;
        this.staffRating = staffRating;
        this.picUrl = picUrl;
        this.logoUrl = logoUrl;
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

    public float getMoodRating() {
        return moodRating;
    }

    public void setMoodRating(float moodRating) {
        this.moodRating = moodRating;
    }

    public float getStaffRating() {
        return staffRating;
    }

    public void setStaffRating(float staffRating) {
        this.staffRating = staffRating;
    }

    public void setPriceRating(float priceRating) {
        this.priceRating = priceRating;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
