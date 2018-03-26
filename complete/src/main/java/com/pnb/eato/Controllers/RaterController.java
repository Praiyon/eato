package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RaterDBService;
import com.pnb.eato.Models.Rater;
import com.pnb.eato.Models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RaterController {

     @Autowired
     RaterDBService raterDBService;
     @GetMapping(value = "/rater")
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
}
