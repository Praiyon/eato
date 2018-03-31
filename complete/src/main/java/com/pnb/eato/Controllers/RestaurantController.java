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
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantDBService restauService;

//    @RequestMapping(value= RequestMappings.RESTAU, method= RequestMethod.GET)
//    public Restaurant restaurantGet(@RequestParam("restId") int restId) throws SQLException, ValidationException {
//        Restaurant restaurant = restauService.queryById(restId).stream().findFirst().orElse(null);
//        if (restaurant == null){
//            throw new ValidationException("oh no!");
//        }
//        return restaurant;
//    }

    @RequestMapping(value= RequestMappings.RESTAU, method= RequestMethod.GET)
    public List<Restaurant> restaurantGetByName(@RequestParam(value = "name", required = false) String name) throws SQLException, ValidationException {
        List<Restaurant> restaurants;
        if(name == null){
            restaurants = restauService.getAllRestaurants();
        }else{
            restaurants = restauService.queryByName(name);
            if (restaurants == null){
                throw new ValidationException("oh no!");
            }
        }

        return restaurants;
    }

//    @RequestMapping(value= RequestMappings.RESTAU, method= RequestMethod.GET)
//    public List<Restaurant> restaurantGetByName() throws SQLException, ValidationException {
//        List<Restaurant> restaurants = restauService.getAllRestaurants();
//        if (restaurants == null){
//            throw new ValidationException("oh no!");
//        }
//        return restaurants;
//    }
}
