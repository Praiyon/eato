package com.pnb.eato.Models;

public class TypeHighestFood {
     private String restaurantName;
     private String name;



     public TypeHighestFood(String restaurantName, String name) {
          this.restaurantName = restaurantName;
          this.name = name;
     }

     public TypeHighestFood(){}

     public String getRestaurantName() {
          return restaurantName;
     }

     public void setRestaurantName(String restaurantName) {
          this.restaurantName = restaurantName;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }
}
