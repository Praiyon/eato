package com.pnb.eato.Models;

import java.sql.Date;

public class Location {

    private int locationId;
    private String firstOpenDate;
    private String managerName;
    private String phoneNumber;
    private String streetAddress;
    private int restaurantId;

    public Location(){}

    public Location(int locationId, String firstOpenDate, String managerName, String phoneNumber, String streetAddress, int restaurantId) {
        this.locationId = locationId;
        this.firstOpenDate = firstOpenDate;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.restaurantId = restaurantId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getFirstOpenDate() {
        return firstOpenDate;
    }

    public void setFirstOpenDate(String firstOpenDate) {
        this.firstOpenDate = firstOpenDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
