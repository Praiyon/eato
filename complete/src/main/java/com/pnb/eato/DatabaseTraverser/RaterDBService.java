package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Rater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaterDBService {
     @Autowired
     Connection connection;

     //this is question k
     public List<Rater> getHighestRatersFoodAndMood() throws SQLException {
          String sql = "select rater.* " +
                  "from rater, rating " +
                  "where rater.userid = rating.userid " +
                  "order by (food + mood) desc " +
                  "limit 10;";
          return getObjectList(sql);
     }

     //this is question l
     public List<Rater> getHighestRatersFoodOrMood() throws SQLException {
          String sql = "select rater.* " +
                  "from rater, rating " +
                  "where rater.userid = rating.userid " +
                  "order by greatest(food,mood) desc " +
                  "limit 10";
          return getObjectList(sql);
     }

     //question m
     public Rater mostMenuItemsRated(int restaurantId) throws SQLException {
          String sql = "select * " +
                  "from rater " +
                  "where restaurantid ="+restaurantId+"" +
                  "and userid = (" +
                  "select userid " +
                  "from rating_item " +
                  "group by userid " +
                  "order by count(userid) " +
                  "limit 1" +
                  ");";
          return getObjectList(sql).stream().findAny().orElse(null);
     }

     //question o
     public List<Rater> polarizingRaters() throws SQLException {
          String sql = "select rater.* " +
                  "from rater, rating " +
                  "where rater.userid = rating.userid " +
                  "order by @(food - mood) desc " +
                  "limit 10;";
          return getObjectList(sql);
     }

     //question n
     public List<Rater> ratersLowerAverageThanX(String name) throws SQLException {
          String sql = "select rater1.* " +
                  "from rater as rater1 " +
                  "join rating as rating1 " +
                  "on rating1.userid = rater1.userid " +
                  "where rating1.food + rating1.mood + rating1.price + rating1.staff < " +
                  "(" +
                  "select avg(rating2.food + rating2.mood + rating2.price + rating2.staff) " +
                  "from rater as rater2 " +
                  "join rating as rating2 " +
                  "on rating2.userid = rater2.userid " +
                  "where rater2.name='"+name+"'" +
                  ");";
          return getObjectList(sql);
     }

     public void upvoteByPK(int restauid, int raterid) throws SQLException {
          String sqlGetRep = "select * from rater where restaurantId="+restauid+ " and raterid="+raterid+";";
          Rater rater = getObjectList(sqlGetRep).stream().findAny().orElse(null);
          int newRep = rater.getReputation() + 1;
          if (newRep>=100){
               return;
          }
          String updateSQL = "update rater set reputation = "+ newRep + "where restaurantid="+restauid + " and raterid="+raterid+";";
          Statement st = connection.createStatement();
          st.executeUpdate(updateSQL);
     }

     public void downvoteByPK(int restauid, int raterid) throws SQLException {
          String sqlGetRep = "select * from rater where restaurantId="+restauid+ " and raterid="+raterid+";";
          Rater rater = getObjectList(sqlGetRep).stream().findAny().orElse(null);
          int newRep = rater.getReputation() - 1;
          if (newRep<=0){
               return;
          }
          String updateSQL = "update rater set reputation = "+ newRep + "where restaurantid="+restauid + " and raterid="+raterid+";";
          Statement st = connection.createStatement();
          st.executeUpdate(updateSQL);
     }

     public int getRepById(int id) throws SQLException {
          String sql ="select * from rater where userid="+id+";";
          Rater rater = getObjectList(sql).stream().findFirst().orElse(null);
          if (rater != null){
               return rater.getReputation();
          }
          return -1000;
     }

     public String getUsernameById(int id) throws SQLException {
          String sql ="select * from rater where userid="+id+";";
          Rater rater = getObjectList(sql).stream().findFirst().orElse(null);
          if (rater != null){
               return rater.getUsername();
          }
          return null;
     }

     public List<Rater>queryByNameAndType(String name, String type) throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "name = '"+name +"' AND type = '" +type  +"'";
          return getObjectList(sql);
     }

     public List<Rater> queryByName(String name) throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "name = '"+name+"';";
          return getObjectList(sql);
     }

     public List<Rater> queryByEmail(String email)  throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "email = '"+email+"';";
          return getObjectList(sql);
     }

     public List<Rater> queryByUsername(String username)  throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "username = '"+username+"';";
          return getObjectList(sql);
     }

     public void insert(Rater toInsert) throws SQLException {
          String sql = "INSERT INTO RATER (EMAIL, NAME, TYPE, JOIN_DATE, PASSWORD, USERNAME, REPUTATION) VALUES (";
          sql += "'"+ toInsert.getEmail() +"'," +
                 "'"+ toInsert.getName() +"', " +
                 "'"+ toInsert.getType() +"', " +
                 "CURRENT_DATE,"+
                 "'"+ toInsert.getPassword() +"', " +
                 "'"+ toInsert.getUsername() +"', " +
                 toInsert.getReputation()+
                  ");";
          Statement st = connection.createStatement();
          st.executeUpdate(sql);
     }

     private List<Rater> getObjectList(String sql) throws SQLException {
          List<Rater> raterList = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);

          while (rs.next()){
               Integer userId = rs.getInt("USERID");
               String email = rs.getString("EMAIL");
               String name = rs.getString("NAME");
               String type = rs.getString("TYPE");
               Date date = rs.getDate("JOIN_DATE");
               String password = rs.getString("PASSWORD");
               String username = rs.getString("USERNAME");
               Integer reputation = rs.getInt("REPUTATION");
               raterList
                       .add(new Rater(userId, email, name, date, type, username, password, reputation));

          }
          return raterList;
     }

}
