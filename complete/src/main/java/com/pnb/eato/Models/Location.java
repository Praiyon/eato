package com.pnb.eato.Models;

import java.sql.Date;

public class Location {

    private int locationId;
    private Date firstOpenDate;
    private String managerName;
    private int phoneNumber;
    private String streetAddress;
    private int restaurantId;

    public Location(){}

    public Location(int locationId, Date firstOpenDate, String managerName, int phoneNumber, String streetAddress, int restaurantId) {
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

    public Date getFirstOpenDate() {
        return firstOpenDate;
    }

    public void setFirstOpenDate(Date firstOpenDate) {
        this.firstOpenDate = firstOpenDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
