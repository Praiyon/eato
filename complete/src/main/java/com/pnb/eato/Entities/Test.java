package com.pnb.eato.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Test")
public class Test {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     private String firstName;
     private String lastName;

     public Test(){}
     public Test (long id, String firstName, String lastName){
          this.firstName = firstName;
          this.lastName = lastName;
          this.id = id;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
}
