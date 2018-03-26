package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.RatingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatingItemDBService {

    @Autowired
    Connection con;

    private List<RatingItem> getObjectList(String sql) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<RatingItem> ratingItemList = new ArrayList<>();

        while (rs.next()){
            int userId = rs.getInt("UserID");
            Date date = rs.getDate("date");
            int itemId = rs.getInt("ItemID");
            int rating = rs.getInt("rating");
            String comment = rs.getString("comment");

            ratingItemList.add(new RatingItem(userId, date, itemId, rating, comment));
        }
        return ratingItemList;
    }

    public void insert(int userId, Date date, int itemId, int rating, String comment) throws SQLException {
        String sql = "INSERT INTO RATING_ITEM (userid, date, itemid, rating, comment)" +
                "VALUES(" +
                userId +","+
                "to_date('"+date.toString()+"',"+
                itemId+","+
                rating+","+
                "'" + comment+ "'"+
                ");";
        Statement st = con.createStatement();
        st.executeUpdate(sql);
    }
}
