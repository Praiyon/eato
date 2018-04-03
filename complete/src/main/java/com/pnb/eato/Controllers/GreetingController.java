package com.pnb.eato.Controllers;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;


import com.pnb.eato.DatabaseTraverser.RestaurantDBService;
import com.pnb.eato.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    RestaurantDBService restaurantDBService;
    private static final String template = "<h1 color='green'>Hello, %s!</h1>";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        try {
//            databaseService.insertRestaurant(123, "restaur","food","www.abc.dasd");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
    //}

    @GetMapping(value = "/greeting")
    public void greeting(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            restaurantDBService.insertRestaurant("test","test","test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Restaurant restaurant;
//        try {
//            restaurant = restaurantDBService.queryByLikeName("a").stream().findAny().orElse(null);
//        } catch (SQLException e) {
//            restaurant = null;
//            e.printStackTrace();
//        }
//        return restaurant;
    }




}
