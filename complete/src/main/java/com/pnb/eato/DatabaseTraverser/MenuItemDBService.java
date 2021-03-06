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

    public List<MenuItem> getMenuItems(int restaurantId) throws SQLException{
        String sql = "select * from menu_item " +
                "where restaurantid = "+restaurantId;
        return getObjectList(sql);
    }

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
        String sql = "INSERT INTO  MenuItem " +
                "(name, type, category, description, price, restaurantid) " +
                "VALUES(" +
                "'"+name+"'," +
                "'"+category+"'," +
                "'"+description+"'," +
                price+","+
                restaurantId+
                ");";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }

    public void delete (int id ) throws SQLException {
        String sql = "delete from rating_item where itemid="+id+";"+
                "delete from menu_item where itemid="+id+";";
        Statement st = connection.createStatement();
        st.execute(sql);
    }
}
