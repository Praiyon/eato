package com.pnb.eato.Models;

public class TotalRatingRest {

     //for f

     private String name;
     private String restaurantName;
     private Integer totalRating;

     public TotalRatingRest(String name, String restaurantName, Integer totalRating) {
          this.name = name;
          this.restaurantName = restaurantName;
          this.totalRating = totalRating;
     }

     public TotalRatingRest(){}


     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getRestaurantName() {
          return restaurantName;
     }

     public void setRestaurantName(String restaurantName) {
          this.restaurantName = restaurantName;
     }

     public Integer getTotalRating() {
          return totalRating;
     }

     public void setTotalRating(Integer totalRating) {
          this.totalRating = totalRating;
     }
}
