package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RestaurantDBService;
import com.pnb.eato.Models.Restaurant;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.sql.SQLException;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantDBService restauService;

    @RequestMapping(value= RequestMappings.RESTAU, method= RequestMethod.GET)
    public Restaurant restaurantGet(@RequestParam("restId") int restId) throws SQLException, ValidationException {
        Restaurant restaurant = restauService.queryById(restId).stream().findFirst().orElse(null);
        if (restaurant == null){
            throw new ValidationException("oh no!");
        }
        return restaurant;
    }
}
