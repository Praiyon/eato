package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Rater;
import com.pnb.eato.Models.Rating;
import com.pnb.eato.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaterDBService {
     @Autowired
     Connection connection;

     public void upvoteByPK(int restauid, int raterid) throws SQLException {
          String sqlGetRep = "select * from rater where restaurantId="+restauid+ " and raterid="+raterid+";";
          Rater rater = getResultSet(sqlGetRep).stream().findAny().orElse(null);
          int newRep = rater.getReputation() + 1;
          if (newRep>99){
               return;
          }
          String updateSQL = "update rater set reputation = "+ newRep + "where restaurantid="+restauid + " and raterid="+raterid+";";
          Statement st = connection.createStatement();
          st.executeUpdate(updateSQL);
     }

     public int getRepById(int id) throws SQLException {
          String sql ="select * from rater where userid="+id+";";
          Rater rater = getResultSet(sql).stream().findFirst().orElse(null);
          if (rater != null){
               return rater.getReputation();
          }
          return -1000;
     }

     public String getUsernameById(int id) throws SQLException {
          String sql ="select * from rater where userid="+id+";";
          Rater rater = getResultSet(sql).stream().findFirst().orElse(null);
          if (rater != null){
               return rater.getUsername();
          }
          return null;
     }

     public List<Rater>queryByNameAndType(String name, String type) throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "name = '"+name +"' AND type = '" +type  +"'";
          return getResultSet(sql);
     }

     public List<Rater> queryByName(String name) throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "name = '"+name+"';";
          return getResultSet(sql);
     }

     public List<Rater> queryByEmail(String email)  throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "email = '"+email+"';";
          return getResultSet(sql);
     }

     public List<Rater> queryByUsername(String username)  throws SQLException {
          String sql = "SELECT * FROM RATER WHERE ";
          sql += "username = '"+username+"';";
          return getResultSet(sql);
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

     private List<Rater> getResultSet(String sql) throws SQLException {
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
