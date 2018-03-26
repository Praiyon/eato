package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDBService {

    @Autowired
    Connection connection;

    private List<Location> getResultSet(String sql) throws SQLException {
        List<Location> locationList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()){
            int restId = rs.getInt("LocationID");
            Date rName = rs.getDate("first_open_id");
            String managerName = rs.getString("manager_name");
            int phoneNumber = rs.getInt("phone_number");
            String streetAddress = rs.getString("street_address");
            int restaurantId = rs.getInt("restaurantId");
            locationList.add(new Location())
        }
        return locationList;
    }

}
