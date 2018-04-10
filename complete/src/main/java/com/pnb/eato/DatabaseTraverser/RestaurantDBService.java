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

     public void insertRestaurant (Restaurant restaurant) throws SQLException {

          String sql = "INSERT INTO RESTAURANT (NAME, TYPE, URL, FOOD_PIC, LOGO) VALUES " +
                  "('" + restaurant.getName() + "','" + restaurant.getType()
                  + "','" + restaurant.getUrl() + "','" + restaurant.getUrlPic()  +
                  "','" + restaurant.getUrlLogo() + "');";
          Statement statement;
          statement = connection.createStatement();
          statement.executeUpdate(sql);

     }

     public List<Restaurant> queryById(Integer id) throws SQLException{
          String sql = "SELECT * FROM RESTAURANT WHERE ";
          sql += "restaurantid="+id+";";
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

     public List<Restaurant> queryByLikeName(String name) throws SQLException {
          String sql = "SELECT * FROM RESTAURANT WHERE ";
          String[] likeWords = name.split(" ");
          for (int i = 0 ; i < likeWords.length; i++){
               sql += "name like '%" +likeWords[i]+"%' ";
               if (i != likeWords.length - 1) {
                    sql+= "AND ";
               }
          }
          sql += ";";
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
               String food_pic = rs.getString("food_pic");
               String url_logo = rs.getString("logo");
               restaurantList
                       .add(new Restaurant(restId, rName, type, URL, food_pic, url_logo));

          }
          return restaurantList;
     }

     public List<String> getCategories() throws SQLException {
          String sql = "SELECT DISTINCT TYPE FROM RESTAURANT;";
          List<String> categories = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);

          while(rs.next()){
               String category = rs.getString("type");
               categories.add(category);
          }
          return categories;
     }

     public void deleteByID(int id) throws SQLException {
          String sql = "delete " +
                  "from rating_item " +
                  "where "+ id + "  in ( " +
                  "   select restaurantid " +
                  "   from menu_item " +
                  "   where restaurantid="+id+
                  ");" +
                  "delete " +
                  "from menu_item " +
                  "where restaurantid="+id+"; " +
                  "delete " +
                  "from rating " +
                  "where restaurantid="+id+"; " +
                  "delete " +
                  "from restaurant " +
                  "where restaurantid = "+id+";";
          Statement st = connection.createStatement();
          st.execute(sql);
     }



}
