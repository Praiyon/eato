package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DatabaseService {

     @Autowired
     Connection connection;

     Statement statement;

     public void insertRestaurant (Integer id,
                                   String name,
                                   String type,
                                   String url ) throws SQLException {
          String sql = "INSERT INTO RESTAURANT VALUES " +
                  "(" + id + ",'" + name + "','" + type + "','" + url + "');";

          statement = connection.createStatement();
          statement.executeUpdate(sql);

     }




}
