package com.pnb.eato.Models;

public class JanuaryRest {

     private String phoneNumber;
     private String name;
     private String Date;
     private String type;

     public JanuaryRest(String phoneNumber, String name, String date, String type) {
          this.phoneNumber = phoneNumber;
          this.name = name;
          Date = date;
          this.type = type;
     }

     public JanuaryRest(){}

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public void setPhoneNumberw(String phoneNumber) {
          this.phoneNumber = phoneNumber;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDate() {
          return Date;
     }

     public void setDate(String date) {
          Date = date;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }
}
