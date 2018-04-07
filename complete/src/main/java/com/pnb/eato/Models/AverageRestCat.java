package com.pnb.eato.Models;

public class AverageRestCat {

     private Double avg;

     private String type;

     private String category;

     public AverageRestCat(Double avg, String type, String category) {
          this.avg = avg;
          this.type = type;
          this.category = category;
     }

     public Double getAvg() {
          return avg;
     }

     public void setAvg(Double avg) {
          this.avg = avg;
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
}
