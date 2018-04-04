package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.DatabaseTraverser.RatingDBService;
import com.pnb.eato.Models.Rating;
import com.pnb.eato.Models.RatingDisplay;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RatingController {

    @Autowired
    RaterDBService raterService;

    @Autowired
    RatingDBService ratingDBService;

    @RequestMapping(value=RequestMappings.RATE, method= RequestMethod.GET)
    public List<RatingDisplay> rate(@RequestParam(value = "restid", required = false) int restId) throws SQLException {
        List<Rating> ratingList = ratingDBService.getAllRatingsOfRestaurant(restId);
        List<RatingDisplay> returnList = new ArrayList<>();

        ratingList.stream().forEach(rating -> {
                    try {
                        returnList.add(new RatingDisplay(
                                rating.getDate(),
                                rating.getPrice(),
                                rating.getFood(),
                                rating.getMood(),
                                rating.getStaff(),
                                rating.getComments(),
                                raterService.getUsernameById(rating.getUserID()),
                                raterService.getRepById(rating.getUserID())
                        ));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );
        return returnList;
    }

}
