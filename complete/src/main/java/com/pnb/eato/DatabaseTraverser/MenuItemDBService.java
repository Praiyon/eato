package com.pnb.eato.DatabaseTraverser;

import com.pnb.eato.Models.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemDBService {

    @Autowired
    Connection connection;

    private List<MenuItem> getObjectList(String sql) throws SQLException {
        List<MenuItem> menuItemList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int itemId = rs.getInt("itemId");
            String name = rs.getString("name");
            String type = rs.getString("type");
            String category = rs.getString("category");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            int restaurantId = rs.getInt("restaurantId");
            menuItemList.add(new MenuItem(itemId, name, type, category, description, price, restaurantId));
        }
        return menuItemList;
    }

    public void insert(String name, String type, String category, String description, double price, int restaurantId) throws SQLException {
        String sql = "INSERT INTO  MenuItem VALUES(" +
                "'"+name+"'," +
                "'"+category+"'," +
                "'"+description+"'," +
                price+","+
                restaurantId+
                ");";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }
}
