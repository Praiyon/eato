package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtraQueryService {

     @Autowired
     Connection connection;

     public List<TotalRatingRest> getTotalRatingRest() throws SQLException {
          String sql = "select r.name, rest.name, count(rat.userid) " +
                  "from rater as r, restaurant as rest, rating as rat " +
                  "where rest.restaurantid=rat.restaurantid and r.userid=rat.userid " +
                  "group by(rest.restaurantid, rat.userid, r.userId);";

          List<TotalRatingRest> list = new ArrayList<>();

          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          System.out.println(rs);

          while (rs.next()){
               String name = rs.getString("name");
               String restaurantName = rs.getString("name");
               int totalCount = rs.getInt("count(userid)");

               list.add(new TotalRatingRest(name, restaurantName, totalCount));
          }
          return list;
     }

     public void getJanuaryRest() throws SQLException {
          String sql ="select loc.phone_number, rest.name, rat.date, rest.type " +
                  "from location as loc, restaurant as rest, rating as rat " +
                  "where loc.restaurantid=rest.restaurantid and " +
                  "rat.restaurantid=rest.restaurantid and not(to_char(rat.date,'MMYYYY')='012015');";
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          List<JanuaryRest> list = new ArrayList<>();
          while (rs.next()){
               String phoneNumber = rs.getString("phoneNumber");
               String name = rs.getString("name");
               String date = rs.getDate("date").toString();
               String type = rs.getString("type");

               list.add(new JanuaryRest(phoneNumber, name, date, type));
          }
     }

     public void staffRatingLower(String name) throws SQLException {
          String sql = "select rest.name, loc.first_open_id\n" +
                  "from location as loc, restaurant as rest, rating as rat\n" +
                  "where rest.restaurantid=loc.restaurantid and rest.restaurantId=rat.restaurantId and rat.staff <\n" +
                  "any(select ra.price " +
                  "    from rating as ra, rater as r " +
                  "    where ra.userid=r.userid and r.name='"+name+"') " +
                  "or rat.staff< " +
                  "any(select ra.staff " +
                  "    from rating as ra, rater as r " +
                  "    where ra.userid=r.userid and r.name='"+name+"') " +
                  "or rat.staff< " +
                  "any(select ra.food " +
                  "    from rating as ra, rater as r " +
                  "    where ra.userid=r.userid and r.name='"+name+"') " +

                  "or rat.staff< " +
                  "any(select ra.mood " +
                  "    from rating as ra, rater as r " +
                  "    where ra.userid=r.userid and r.name='"+name+"') " +
                  "order by(rat.date);";


          List<StaffRating> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String restName = rs.getString("name");
               String date = rs.getDate("first_open_id").toString();

               list.add(new StaffRating(restName, date));
          }






     }

     public void getManagerCategory(String type) throws SQLException {
          String sql = "select location.manager_name, location.first_open_id, restaurant.name " +
                  "from location, restaurant " +
                  "where location.restaurantid = restaurant.restarauntid " +
                  "and location.restaurantid = '"
                  +type
                  + "';";
          List<ManagerCategory> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String managerName = rs.getString("manager_name");
               String date = rs.getDate("first_open_id").toString();

               list.add(new ManagerCategory(managerName, date));
          }
     }



     public void getHighestItem(int restaurantId) throws SQLException {
          String sql = "select max(price) as highestItem " +
                  "from menu_item " +
                  "where restaurantid ='"+restaurantId+ "';";

          List<HighestPrice> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               Double price = rs.getDouble("price");
               list.add(new HighestPrice(price));
          }
     }

     public void gettypeHighestFood() throws SQLException {
          String sql = "SELECT REST.NAME, RA.NAME " +
                  "FROM RESTAURANT AS REST, LOCATION AS LOC, RATING AS RATI, RATER AS RA " +
                  "WHERE (REST.RESTAURANTID=LOC.RESTAURANTID AND RATI.RESTAURANTID=REST.RESTAURANTID AND RA.USERID=RATI.USERID AND RATI.FOOD =(\n" +
                  "     SELECT MAX(RAT.FOOD) " +
                  "    FROM LOCATION AS LOCA, RATING AS RAT, RESTAURANT AS RESTA " +
                  "    WHERE LOCA.RESTAURANTID=RESTA.RESTAURANTID AND RAT.RESTAURANTID=RESTA.RESTAURANTID " +
                  "));";

          List<TypeHighestFood> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String restaurantName = rs.getString("REST.NAME");
               String raterName = rs.getString("RA.NAME");
               list.add(new TypeHighestFood(restaurantName,raterName));
          }
     }


}
