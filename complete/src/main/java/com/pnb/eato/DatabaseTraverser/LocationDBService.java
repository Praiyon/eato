package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationDBService {

    @Autowired
    Connection connection;

    public List<Location> queryByLocationId(int lcoationId) throws SQLException {
        String sql = "SELECT * FROM location WHERE ";
        sql += "locationId=" + lcoationId;
        return getObjectList(sql);
    }

    public List<Location> queryByRestaurantId(int restaurantId) throws SQLException {
        String sql = "SELECT * FROM location WHERE ";
        sql += "restaurantId=" + restaurantId;
        return getObjectList(sql);
    }

    public List<Location> getByStreetAddress(String streetAddress) throws SQLException{
        String newStreetAddress = streetAddress.trim();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * FROM location WHERE ");
        String[] streetArray = newStreetAddress.split(" ");
        for (int i = 0; i < streetArray.length; i++){
            streetArray[i] = "%" +streetArray[i]  +"%";
            if (i == streetArray.length -1){
                sqlBuilder.append("street_address LIKE '%" +streetArray[i] +"%'; ");
            } else {
                sqlBuilder.append("street_address LIKE '%" +streetArray[i] +"%' AND ");
            }
        }
        return getObjectList(sqlBuilder.toString());
    }

    public List<Location> getAllLocations() throws SQLException {
        return getObjectList("SELECT * FROM Location");
    }

    private List<Location> getObjectList(String sql) throws SQLException {
        List<Location> locationList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()){
            int locationID = rs.getInt("LocationID");
            Date firstOpenId = rs.getDate("first_open_id");
            String managerName = rs.getString("manager_name");
            int phoneNumber = rs.getInt("phone_number");
            String streetAddress = rs.getString("street_address");
            int restaurantId = rs.getInt("restaurantId");
            locationList.add(new Location(locationID, firstOpenId, managerName, phoneNumber, streetAddress, restaurantId));
        }
        return locationList;
    }

    public void insert(Date firstOpenId, String managerName, int phoneNumber, String streetAddress, int restaurantId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Location VALUES(" +
                "to_date('"+firstOpenId.toString()+"'),"+
                "'"+managerName+"',"+
                phoneNumber+","+
                "'"+streetAddress+"',"+
                restaurantId+
                ");");
    }

}
