package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.DatabaseTraverser.RatingDBService;
import com.pnb.eato.DatabaseTraverser.RatingItemDBService;
import com.pnb.eato.Models.MenuItem;
import com.pnb.eato.Models.Rating;
import com.pnb.eato.Models.RatingDisplay;
import com.pnb.eato.Models.RatingItem;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RatingController {

    @Autowired
    RaterDBService raterService;

    @Autowired
    RatingDBService ratingDBService;

    @Autowired
    RatingItemDBService ratingItemDBService;

    @RequestMapping(value=RequestMappings.UPVOTE, method=RequestMethod.GET)
    public void upvote(@RequestParam(value ="raterid") int raterId) throws SQLException {
        raterService.upvoteByPK(raterId);
    }

    @RequestMapping(value=RequestMappings.DOWNVOTE, method=RequestMethod.GET)
    public void downvote(@RequestParam(value ="raterid") int raterId) throws SQLException {
        raterService.downvoteByPK(raterId);
    }

    @RequestMapping(value=RequestMappings.RATE, method=RequestMethod.POST)
    public void postRate(@RequestBody Rating newRating) throws SQLException {
        ratingDBService.insert(newRating);
    }

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
                                raterService.getRepById(rating.getUserID()),
                                rating.getUserID()
                        ));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );
        return returnList;
    }

    @RequestMapping(value= RequestMappings.MENUITEMRATING, method= RequestMethod.GET)
    public List<RatingItem> getMenuItemRating(@RequestParam(value = "id") int id) throws SQLException {
        return (ratingItemDBService.getRatingItem(id));
    }

}
