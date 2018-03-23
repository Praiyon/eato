package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConf {

     @Value("${db.user}")
     private String username;
     @Value("${db.password}")
     private String password;
     @Value("${db.connection}")
     private String connection;

     @Bean
     public Connection connect() throws SQLException {
          return DriverManager.getConnection(connection, username, password);
     }
//     @Bean
//     public TestTraverserService testTraverser(){
//          return new TestTraverserService();
//     }
}
