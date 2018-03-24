package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

     @Value("${eato.db.user}")
     private String username;
     @Value("${eato.db.password}")
     private String password;
     @Value("${eato.db.connection}")
     private String connection;

     Connection con;

     public DBConnection() throws SQLException {
          con = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/pkuma076",
                  "pkuma076"
                  , "hoyaHOYA4!");
     }

     public Connection getCon() {
          return con;
     }

     public void setCon(Connection con) {
          this.con = con;
     }

}
