package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RatingDBService;
import com.pnb.eato.DatabaseTraverser.RestaurantDBService;
import com.pnb.eato.Models.Restaurant;
import com.pnb.eato.Request.RequestMappings;
import com.pnb.eato.RequestBody.RestaurantCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantDBService restauService;

    @Autowired
    private RatingDBService ratingService;

//    @RequestMapping(value= RequestMappings.RESTAU+"", method= RequestMethod.GET)
//    public Restaurant restaurantGet(@RequestParam(value = "id") int restId) throws SQLException, ValidationException {
//        Restaurant restaurant = restauService.queryById(restId).stream().findFirst().orElse(null);
//        if (restaurant == null){
//            throw new ValidationException("oh no!");
//        }
//        return restaurant;
//    }

    @RequestMapping(value= RequestMappings.RESTAU, method= RequestMethod.GET)
    public List<RestaurantCard> restaurantGetByName(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "id", required = false) Integer id) throws SQLException, ValidationException {
        List<Restaurant> restaurants;
        List<RestaurantCard> restCardList = new ArrayList<>();
        if(id != null){
            Restaurant restaurant = restauService.queryById(id).stream().findFirst().orElse(null);
            RestaurantCard card = new RestaurantCard(
                    restaurant.getName(),
                    restaurant.getRestaurantId(),
                    ratingService.getFoodOfRestaurant(id),
                    ratingService.getPriceOfRestaurant(id),
                    ratingService.getMoodOfRestaurant(id),
                    ratingService.getStaffOfRestaurant(id),
                    restaurant.getUrlPic(),
                    restaurant.getUrlLogo()
                    );
            restCardList.add(card);

        }else {
            restaurants = name == null ?
                    restauService.getAllRestaurants()
                    : restauService.queryByLikeName(name);
            if (restaurants == null){
                throw new ValidationException("oh no!");
            }
            restaurants.stream().forEach(r -> {
                try {
                    restCardList.add(new RestaurantCard(
                            r.getName(),
                            r.getRestaurantId(),
                            ratingService.getFoodOfRestaurant(r.getRestaurantId()),
                            ratingService.getPriceOfRestaurant(r.getRestaurantId()),
                            ratingService.getMoodOfRestaurant(r.getRestaurantId()),
                            ratingService.getStaffOfRestaurant(r.getRestaurantId()),
                            r.getUrlPic(),
                            r.getUrlLogo())
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        return restCardList;
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
