package com.pnb.eato.Controllers;

import com.pnb.eato.DatabaseTraverser.MenuItemDBService;
import com.pnb.eato.Models.MenuItem;
import com.pnb.eato.Request.RequestMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemDBService menuItemService;

    @RequestMapping(value= RequestMappings.GETMENU, method= RequestMethod.GET)
    public List<MenuItem> getMenu(@RequestParam(value = "restId") int restaurantId) throws SQLException {
        return menuItemService.getMenuItems(restaurantId);
    }
}
