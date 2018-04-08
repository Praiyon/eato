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
               int totalCount = rs.getInt("count");

               list.add(new TotalRatingRest(name, restaurantName, totalCount));
          }
          return list;
     }

     public List<JanuaryRest> getJanuaryRest() throws SQLException {
          String sql ="select loc.phone_number, rest.name, rat.date, rest.type " +
                  "from location as loc, restaurant as rest, rating as rat " +
                  "where loc.restaurantid=rest.restaurantid and " +
                  "rat.restaurantid=rest.restaurantid and not(to_char(rat.date,'MMYYYY')='012015');";
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          List<JanuaryRest> list = new ArrayList<>();
          while (rs.next()){
               String phoneNumber = rs.getString("phone_number");
               String name = rs.getString("name");
               String date = rs.getDate("date").toString();
               String type = rs.getString("type");

               list.add(new JanuaryRest(phoneNumber, name, date, type));
          }

          return list;
     }

     public List<StaffRating> getStaffRatingLower(String name) throws SQLException {
          String sql = "SELECT REST.NAME, LOCATION.FIRST_OPEN_ID, RAT " +
                  "FROM RESTAURANT AS REST " +
                  "JOIN " +
                  "RATING AS RAT " +
                  "ON RAT.RESTAURANTID=REST.RESTAURANTID " +
                  "JOIN LOCATION " +
                  "ON RAT.RESTAURANTID=LOCATION.RESTAURANTID " +
                  "WHERE RAT.STAFF < ( " +
                  "select greatest(food, mood, staff, price) " +
                  "from rating " +
                  "join rater " +
                  "on rating.userid = rater.userid " +
                  "where rater.name='"+name+"'"+
                  "order by greatest(food,mood, staff, price) asc " +
                  "limit 1);";


          List<StaffRating> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String restName = rs.getString("name");
               String date = rs.getDate("first_open_id").toString();

               list.add(new StaffRating(restName, date));
          }

          return list;





     }

     public List<ManagerCategory> getManagerCategory(String type) throws SQLException {
          String sql = "select location.manager_name, location.first_open_id, restaurant.name " +
                  "from location, restaurant " +
                  "where location.restaurantid = restaurant.restaurantid " +
                  "and restaurant.type = '" +type+"';";
          List<ManagerCategory> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String managerName = rs.getString("manager_name");
               String date = rs.getDate("first_open_id").toString();

               list.add(new ManagerCategory(managerName, date));
          }
          return list;
     }



     public List<HighestPrice> getHighestItem(int restaurantId) throws SQLException {
          String sql = "select max(price) as highestItem " +
                  "from menu_item " +
                  "where restaurantid ='"+restaurantId+ "';";

          List<HighestPrice> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               Double price = rs.getDouble("highestitem");
               list.add(new HighestPrice(price));
          }

          return list;
     }

     public List<AverageRestCat> getAverageRestCat() throws SQLException {
          String sql="select restaurant.type,menu_item.category, avg(menu_item.price) " +
                  "from menu_item " +
                  "join restaurant " +
                  "on restaurant.restaurantid = menu_item.restaurantid " +
                  "where restaurant.type in ( " +
                  "    select rest2.type " +
                  "    from restaurant as rest2 " +
                  "    group by rest2.type " +
                  ") " +
                  "group by menu_item.category, restaurant.type;";
          List<AverageRestCat> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               Double price = rs.getDouble("avg");
               String type = rs.getString("type");
               String category = rs.getString("category");

               list.add(new AverageRestCat(price, type, category));
          }

          return list;
     }

     public List<TypeHighestFood> getTypeHighestFood(String type) throws SQLException {
          String sql = "SELECT REST.NAME, RATER.NAME " +
                  "FROM RESTAURANT AS REST " +
                  "JOIN RATING ON RATING.RESTAURANTID=REST.RESTAURANTID " +
                  "JOIN RATER ON RATING.USERID=RATER.USERID " +
                  "WHERE REST.TYPE='" + type + "' and RATING.FOOD=( " +
                  "SELECT MAX(RAT.FOOD) " +
                  "    FROM LOCATION AS LOCA, RATING AS RAT, RESTAURANT AS RESTA " +
                  "    WHERE LOCA.RESTAURANTID=RESTA.RESTAURANTID AND RAT.RESTAURANTID=RESTA.RESTAURANTID) ";

          List<TypeHighestFood> list = new ArrayList<>();
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(sql);
          while (rs.next()){
               String restaurantName = rs.getString("restaurantname");
               String raterName = rs.getString("ratername");
               list.add(new TypeHighestFood(restaurantName,raterName));
          }

          return list;
     }


}
