package com.pnb.eato.hello;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import com.pnb.eato.DatabaseTraverser.DatabaseService;
import com.pnb.eato.hello.Greeting;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    DatabaseService databaseService;
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
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            databaseService.insertRestaurant(123, "restaur","food","www.abc.dasd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }




}
