package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.ExtraQueryService;
import com.pnb.eato.DatabaseTraverser.LocationDBService;
import com.pnb.eato.Models.*;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class ExtraQueryController {
     @Autowired
     ExtraQueryService extraQueryService;

     @RequestMapping(value= RequestMappings.TOTALRATINGREST, method= RequestMethod.GET)
     public List<TotalRatingRest> getTotalRatingRest() throws SQLException, ValidationException {
          List<TotalRatingRest> totalRatingRests = extraQueryService.getTotalRatingRest();
          return totalRatingRests;
     }

     @RequestMapping(value= RequestMappings.JANUARYREST, method= RequestMethod.GET)
     public List<JanuaryRest> getJanuaryRest() throws SQLException, ValidationException {
          List<JanuaryRest> januaryRest = extraQueryService.getJanuaryRest();
          return januaryRest;
     }

     @RequestMapping(value= RequestMappings.STAFFRATING, method= RequestMethod.GET)
     public List<StaffRating> getStaff(@RequestParam(value = "name", required = true) String name) throws SQLException, ValidationException {
          List<StaffRating> staffRatingLower = extraQueryService.getStaffRatingLower(name);
          return staffRatingLower;
     }

     @RequestMapping(value= RequestMappings.MANAGERCATEGORY, method= RequestMethod.GET)
     public List<ManagerCategory> getManager(@RequestParam(value = "id", required = true) int id) throws SQLException, ValidationException {
          List<ManagerCategory> managerCategories = extraQueryService.getManagerCategory(id);
          return managerCategories;
     }

     @RequestMapping(value= RequestMappings.HIGHESTPRICE, method= RequestMethod.GET)
     public List<HighestPrice> getHighestPrice(@RequestParam(value = "id", required = true) int id) throws SQLException, ValidationException {
          List<HighestPrice> highestPrices = extraQueryService.getHighestItem(id);
          return highestPrices;
     }

     @RequestMapping(value= RequestMappings.AVERAGETYPECAT, method= RequestMethod.GET)
     public List<AverageRestCat> averageRestCats() throws SQLException, ValidationException {
          List<AverageRestCat> averageRestCat= extraQueryService.getAverageRestCat();
          return averageRestCat;
     }

     @RequestMapping(value= RequestMappings.TYPEHIGHESTFOOD, method= RequestMethod.GET)
     public List<TypeHighestFood> getTypeHighest(@RequestParam(value = "type", required = true) String type) throws SQLException, ValidationException {
          return extraQueryService.getTypeHighestFood(type);

     }




}
