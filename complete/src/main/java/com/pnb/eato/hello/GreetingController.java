package com.pnb.eato.hello;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import com.pnb.eato.DatabaseTraverser.TestTraverserService;
import com.pnb.eato.Entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private TestTraverserService testTraverser;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/dbtest")
    public Test addToDB() throws SQLException {
        Test test = new Test(123,"bond","kumarasamy");
        testTraverser.insert();
        return test;

    }
}
