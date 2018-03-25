package com.pnb.eato.Models;

import java.sql.Date;

public class Location {

    private int locationId;
    private Date firstOpenDate;
    private String managerName;
    private int phoneNumber;

    public Location(){}

    public Location(int locationId, Date firstOpenDate, String managerName, int phoneNumber) {
        this.locationId = locationId;
        this.firstOpenDate = firstOpenDate;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
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
