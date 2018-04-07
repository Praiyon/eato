package com.pnb.eato.Models;

public class ManagerCategory {
     private String managerName;
     private String locationOpenDate;

     public ManagerCategory(String managerName, String locationOpenDate) {
          this.managerName = managerName;
          this.locationOpenDate = locationOpenDate;
     }

     public ManagerCategory(){}

     public String getManagerName() {
          return managerName;
     }

     public void setManagerName(String managerName) {
          this.managerName = managerName;
     }

     public String getLocationOpenDate() {
          return locationOpenDate;
     }

     public void setLocationOpenDate(String locationOpenDate) {
          this.locationOpenDate = locationOpenDate;
     }
}
