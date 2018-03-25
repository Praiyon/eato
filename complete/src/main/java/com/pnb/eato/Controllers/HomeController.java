package com.pnb.eato.Controllers;

import com.pnb.eato.Request.RequestMappings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(RequestMappings.INDEX)
    public void homepage(){

    }

//    @RequestMapping("/error")
//    public void error(){
//
//    }

}
