package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.ExtraQueryService;
import com.pnb.eato.DatabaseTraverser.LocationDBService;
import com.pnb.eato.Models.Location;
import com.pnb.eato.Models.TotalRatingRest;
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

     @RequestMapping(value= RequestMappings.LOCATION, method= RequestMethod.GET)
     public List<TotalRatingRest> getTotalRatingRest() throws SQLException, ValidationException {
          extraQueryService.getTotalRatingRest();
          List<TotalRatingRest> locations = null;

          return locations;
     }
}
