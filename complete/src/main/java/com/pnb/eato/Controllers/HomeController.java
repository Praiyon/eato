package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RestaurantDBService;
import com.pnb.eato.Models.Restaurant;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    RestaurantDBService restService;

    @RequestMapping(RequestMappings.INDEX)
    public List<Restaurant> homepage() throws SQLException {
        return restService.getAllRestaurants();
    }
}
