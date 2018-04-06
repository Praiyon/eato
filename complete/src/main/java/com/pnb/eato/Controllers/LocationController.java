package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.LocationDBService;
import com.pnb.eato.Models.Location;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.ValidationException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class LocationController {
     @Autowired
     LocationDBService locationDBService;

     @RequestMapping(value= RequestMappings.LOCATION, method= RequestMethod.GET)
     public List<Location> restaurantGetByName(@RequestParam(value = "restauId", required = false) Integer restauId,
                                               @RequestParam(value = "id", required = false) Integer id) throws SQLException, ValidationException {
          List<Location> locations = null;
          if (restauId != null){
               locations = locationDBService.queryByRestaurantId(restauId);
          }
          else if (id != null){
               locations = locationDBService.queryByLocationId(id);
          }
          return locations;
     }
}
