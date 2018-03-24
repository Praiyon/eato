package com.pnb.eato.hello;

import com.pnb.eato.DatabaseTraverser.DBConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan({"com.pnb.eato.DatabaseTraverser"})
@EntityScan("com.pnb.eato.Entities")
public class Application {

    public static void main(String[] args) {
        try {
            DBConnection dbConnection = new DBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }
}
