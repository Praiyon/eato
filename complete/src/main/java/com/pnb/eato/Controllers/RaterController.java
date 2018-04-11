package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.Models.RankingDisplays;
import com.pnb.eato.Models.Rater;
import com.pnb.eato.Request.RequestMappings;
import com.pnb.eato.RequestBody.Login;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.util.ArrayList;
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
     public List<RankingDisplays> highestRaterFAM() throws SQLException {
          List<RankingDisplays> returnList = new ArrayList<>();
          raterDBService.getHighestRatersFoodAndMood().stream().forEach(r->
               returnList.add(new RankingDisplays(
                       r.getName(),
                       r.getJoinDate().toString(),
                       r.getReputation()
               ))
          );
          return returnList;
     }

     @RequestMapping(value=RequestMappings.HIGHEST_FOOD_OR_MOOD, method=RequestMethod.GET)
     public List<RankingDisplays> highestRaterFOM() throws SQLException {
          List<RankingDisplays> returnList = new ArrayList<>();
          raterDBService.getHighestRatersFoodOrMood().stream().forEach(r->
                  returnList.add(new RankingDisplays(
                          r.getName(),
                          r.getJoinDate().toString(),
                          r.getReputation()
                  ))
          );
          return returnList;
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
     public List<RankingDisplays> polarizingRaters() throws SQLException {
          List<RankingDisplays> returnList = new ArrayList<>();
          raterDBService.polarizingRaters().stream().forEach(r->
               returnList.add(new RankingDisplays(
                       r.getName(),
                       r.getJoinDate().toString(),
                       r.getReputation()
               ))
          );
          return returnList;
     }

     @RequestMapping(value=RequestMappings.GET_ALL_RATERS, method = RequestMethod.GET)
     public List<String> getRaterNames() throws SQLException {
          return raterDBService.getAllRaterNames();
     }

     @RequestMapping(value=RequestMappings.DELETE_CURRENT_USER, method = RequestMethod.GET)
     public void deleteUser(@RequestParam(value="userid") int userid) throws SQLException {
          raterDBService.deleteByID(userid);
     }

}
