package com.pnb.eato.Models;

public class StaffRating {
     private String restaurantName;
     private String locationOpenDate;

     public StaffRating(String restaurantName, String locationOpenDate) {
          this.restaurantName = restaurantName;
          this.locationOpenDate = locationOpenDate;
     }

     public StaffRating(){}

     public String getRestaurantName() {
          return restaurantName;
     }

     public void setRestaurantName(String restaurantName) {
          this.restaurantName = restaurantName;
     }

     public String getLocationOpenDate() {
          return locationOpenDate;
     }

     public void setLocationOpenDate(String locationOpenDate) {
          this.locationOpenDate = locationOpenDate;
     }
}
