package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConf {

     @Bean
     public Connection connection() throws SQLException {
          return DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/pkuma076",
                  "pkuma076"
                  , "hoyaHOYA4!");
     }
}
