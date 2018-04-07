package com.pnb.eato.Config;

import com.pnb.eato.Request.RequestMappings;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sun.misc.Request;

@Configuration
@EnableWebMvc
public class CrossOriginConf implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(RequestMappings.LOGIN);
        registry.addMapping("/**");
        registry.addMapping(RequestMappings.SIGNUP);
        registry.addMapping(RequestMappings.RATE);

        registry.addMapping(RequestMappings.TOTALRATINGREST);
        registry.addMapping(RequestMappings.JANUARYREST);
        registry.addMapping(RequestMappings.STAFFRATING);
        registry.addMapping(RequestMappings.HIGHESTPRICE);
        registry.addMapping(RequestMappings.MANAGERCATEGORY);
        registry.addMapping(RequestMappings.CATEGORIES);

        registry.addMapping(RequestMappings.LOCATION);

        registry.addMapping("/upvote-rater/");
        registry.addMapping("/downvote-rater/");
    }
}
