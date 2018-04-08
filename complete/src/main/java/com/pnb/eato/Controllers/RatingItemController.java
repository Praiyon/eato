package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.RatingItemDBService;
import com.pnb.eato.Models.RatingItem;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RatingItemController {

    @Autowired
    RatingItemDBService ratingItemService;

    @RequestMapping(value=RequestMappings.RATEITEM, method= RequestMethod.POST)
    public void rateItem(@RequestBody RatingItem ratingItem) throws SQLException {
        ratingItemService.insert(ratingItem);
    }

}
