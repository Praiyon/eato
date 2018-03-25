package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConf {

     @Value("${eato.db.user}")
     private String username;
     @Value("${eato.db.password}")
     private String password;
     @Value("${eato.db.connection}")
     private String connection;

//     Connection con;
//     public DBConnection() throws SQLException {
//          con = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/pkuma076",
//                  "pkuma076"
//                  , "hoyaHOYA4!");
//     }

     @Bean
     public Connection connection() throws SQLException {
          return DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/pkuma076",
                  "pkuma076"
                  , "hoyaHOYA4!");
     }
}
