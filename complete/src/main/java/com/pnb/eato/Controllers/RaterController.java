package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.Models.Rater;
import com.pnb.eato.Request.RequestMappings;
import com.pnb.eato.RequestBody.Login;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class RaterController {

     @Autowired
     RaterDBService raterDBService;

     @RequestMapping(value = RequestMappings.LOGIN ,method=RequestMethod.POST)
     public int login(@RequestBody Login user) throws SQLException, ValidationException {

          Rater loginAttempt = raterDBService.queryByUsername(user.getUsername()).stream().findFirst().orElse(null);

          if (loginAttempt == null) {
               throw new ValidationException("Username or Password is incorrect");
          }

          if (StringUtils.equals(user.getPassword(), loginAttempt.getPassword())){
               //login successful
               return loginAttempt.getUserId();
          } else {
               throw new ValidationException("Username or Password is incorrect");
          }
     }

     @RequestMapping(value=RequestMappings.SIGNUP, method = RequestMethod.GET)
     public void signup(){}

     @RequestMapping(value=RequestMappings.SIGNUP, method = RequestMethod.POST)
     public Rater signupPOST(@RequestBody Rater newUser) throws SQLException, ValidationException {
          /*
               {
                    "uid": "-1",
                    "email": "testingThe@SignUp.Postman",
                    "name": "bondTEST",
                    "joinDate": null,
                    "password": "password123",
                    "username": "bonduser",
                    "reputation": -1,
                    "type": "casual user"
               }
          * */
          boolean validUser = raterDBService.queryByUsername(newUser.getUsername()).size() == 0;
          boolean validEmail = raterDBService.queryByEmail(newUser.getEmail()).size()== 0;

          //if they do not ex
          if (!validUser){
               throw new ValidationException("Username already exists");
          }

          if (!validEmail) {
               throw new ValidationException("Email already exists");
          }
          newUser.setReputation(50);
          raterDBService.insert(newUser);
          return newUser;
     }

     @RequestMapping(value=RequestMappings.HIGHEST_FOOD_AND_MOOD, method=RequestMethod.GET)
     public List<Rater> highestRaterFAM() throws SQLException {
          return raterDBService.getHighestRatersFoodAndMood();
     }

     @RequestMapping(value=RequestMappings.HIGHEST_FOOD_OR_MOOD, method=RequestMethod.GET)
     public List<Rater> highestRaterFOM() throws SQLException {
          return raterDBService.getHighestRatersFoodOrMood();
     }

     @RequestMapping(value=RequestMappings.FREQUENT_RATERS, method=RequestMethod.GET)
     public Rater freqRaters(@RequestParam(value="restId")int restaurantId) throws SQLException {
          return raterDBService.mostMenuItemsRated(restaurantId);
     }

     @RequestMapping(value=RequestMappings.LOWER_THAN_X, method = RequestMethod.GET)
     public List<Rater> lowerAverageThanRaterX(@RequestParam(value="raterName") String raterName) throws SQLException {
          return raterDBService.ratersLowerThanX(raterName);
     }

     @RequestMapping(value=RequestMappings.POLARIZING_RATINGS, method = RequestMethod.GET)
     public List<Rater> polarizingRaters() throws SQLException {
          return raterDBService.polarizingRaters();
     }

}
