package com.pnb.eato.DatabaseTraverser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
@ComponentScan({"com.pnb.eato.DatabaseTraverser"})
public class TestTraverserService {

     @Autowired
     Connection connection;

     public ResultSet insert() throws SQLException {
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("INSERT INTO TEST" +
                  "VALUES (0123,praiyon,yan)");
          return rs;
     }

}
