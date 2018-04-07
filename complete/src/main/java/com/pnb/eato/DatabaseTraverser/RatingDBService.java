package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatingDBService {

    @Autowired
    Connection con;

    public float getPriceOfRestaurant(int restaurantId) throws SQLException {
        String sql = "select avg(price) from rating where restaurantId=" + restaurantId +";";
        return getAverage(sql);
    }

    public float getFoodOfRestaurant(int restaurantId) throws SQLException {
        String sql = "select avg(food) from rating where restaurantId=" + restaurantId +";";
        return getAverage(sql);
    }

    public float getMoodOfRestaurant(int restaurantId) throws SQLException {
        String sql = "select avg(mood) from rating where restaurantId=" + restaurantId +";";
        return getAverage(sql);
    }

    public float getStaffOfRestaurant(int restaurantId) throws SQLException {
        String sql = "select avg(staff) from rating where restaurantId=" + restaurantId +";";
        return getAverage(sql);
    }

    private float getAverage(String sql) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getFloat(1);
        }
        return 0;
    }

    public List<Rating> getAllRatingsOfRestaurant(int restId) throws SQLException {
        String sql = "select * from rating where restaurantId=" +restId+";";
        return getObjectList(sql);
    }

    private List<Rating> getObjectList (String sql) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Rating> ratingList = new ArrayList<>();
        while(rs.next()){
            int userId = rs.getInt("USERID");
            Date date = rs.getDate("DATE");
            double price = rs.getDouble("PRICE");
            double food = rs.getDouble("FOOD");
            double mood = rs.getDouble("MOOD");
            double staff = rs.getDouble("STAFF");
            String comments = rs.getString("COMMENTS");
            int restaurantId = rs.getInt("RESTAURANTID");
            ratingList.add(new Rating(userId, date, price, food, mood, staff, comments, restaurantId));
        }
        return ratingList;
    }

    public void insert(int userId, Date date, double price, double  food, double mood, double staff, String comments, int restaurantId) throws SQLException {
        String sql = "insert into rating " +
                "(userid, date, price, food, mood, staff, comments, restaurantid) "+
                "values (" +
                userId + ","+
                "to_date('" +date.toString() + "','YYYY MM DD')" +
                price + ","+
                food + ","+
                mood + ","+
                staff + ","+
                comments+","+
                restaurantId+
                ");";
        Statement st = con.createStatement();
        st.executeUpdate(sql);
    }

    public void insert(Rating rating) throws SQLException {
        String sql = "insert into rating " +
                "(userid, date, price, food, mood, staff, comments, restaurantid) "+
                "values (" +
                rating.getUserID() + ","+
                "current_date, " +
                rating.getPrice() + ","+
                rating.getFood() + ","+
                rating.getMood() + ","+
                rating.getStaff() + ","+
                "'"+rating.getComments()+"',"+
                rating.getRestaurantId()+
                ");";
        System.out.println(sql);
        Statement st = con.createStatement();
        st.executeUpdate(sql);
    }

}
