package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantDBService {

     @Autowired
     Connection connection;

     public void insertRestaurant (String name,
                                   String type,
                                   String url ) throws SQLException {
          String sql = "INSERT INTO RESTAURANT VALUES " +
                  "('" + name + "','" + type + "','" + url + "');";
          Statement statement;
          statement = connection.createStatement();
          statement.executeUpdate(sql);

     }

     public List<Restaurant> queryById(int id) throws SQLException{
          String sql = "SELECT * FROM RESTAURANT WHERE ";
          sql += "id="+id+";";
          return getObjectList(sql);
     }
     public List<Restaurant> queryByType(String type) throws SQLException {
          String sql = "SELECT * FROM RESTAURANT WHERE ";
          sql += "type = '"+type+"';";
          return getObjectList(sql);
     }

     public List<Restaurant>queryByNameAndType(String name, String type) throws SQLException {
          String sql = "SELECT * FROM RESTAURANT WHERE ";
          sql += "name = '"+name +"' AND type = '" +type  +"'";
          return getObjectList(sql);
     }

     public List<Restaurant> queryByName(String name) throws SQLException {
          String sql = "SELECT * FROM RESTAURANT WHERE ";
               sql += "name = '"+name +"';";
          return getObjectList(sql);
     }

     public List<Restaurant> getAllRestaurants() throws SQLException {
          String sql = "SELECT * FROM RESTAURANT;";
          return getObjectList(sql);
     }

     private List<Restaurant> getObjectList(String sql) throws SQLException {
          List<Restaurant> restaurantList = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);

          while (rs.next()){
               int restId = rs.getInt("RestaurantID");
               String rName = rs.getString("Name");
               String type = rs.getString("Type");
               String URL = rs.getString("URL");
               restaurantList
                       .add(new Restaurant(restId, rName, type, URL));

          }
          return restaurantList;
     }

}
