package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RatingDBService;
import com.pnb.eato.DatabaseTraverser.RestaurantDBService;
import com.pnb.eato.Models.Restaurant;
import com.pnb.eato.Request.RequestMappings;
import com.pnb.eato.RequestBody.RestaurantCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    RestaurantDBService restService;

    @Autowired
    RatingDBService ratingService;
}
