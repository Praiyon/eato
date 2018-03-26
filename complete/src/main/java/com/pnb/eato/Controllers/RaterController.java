package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.Models.Rater;
import com.pnb.eato.Request.RequestMappings;
import com.pnb.eato.RequestBody.Login;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.sql.SQLException;

@RestController
public class RaterController {

     @Autowired
     RaterDBService raterDBService;
     @GetMapping(value = RequestMappings.LOGIN)
     public Rater rating(@RequestParam(value="raterId", required = true) String raterId) {
          Rater rater;
          try {
               rater = raterDBService.queryByName(raterId).stream().findAny().orElse(null);

          } catch (SQLException e) {
               rater = null;
               e.printStackTrace();
          }
          return rater;
     }

     @RequestMapping(value = RequestMappings.LOGIN ,method=RequestMethod.POST)
     public Login login(HttpServletRequest request, @RequestBody Login user) throws SQLException, ValidationException {

          Rater loginAttempt = raterDBService.queryByUsername(user.getUsername()).stream().findFirst().orElse(null);

          if (loginAttempt == null) {
               throw new ValidationException("Username or Password is incorrect");
          }

          if (StringUtils.equals(user.getPassword(), loginAttempt.getPassword())){
               //login successful
               request.setAttribute("uid", loginAttempt.getUserId());
               return user;
          } else {
               throw new ValidationException("Username or Password is incorrect");
          }
     }

     @RequestMapping(value="/session", method = RequestMethod.GET)
     public Object testPost(HttpServletRequest request) throws ValidationException {
          if (request.getAttribute("uid") == null){
               throw new ValidationException("not logged in");
          } else {
               return(request.getAttribute("uid"));
          }
     }


}
