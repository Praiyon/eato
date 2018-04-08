package com.pnb.eato.Request;

public class RequestMappings {

//    HOME CONTROLLER
    public static final String INDEX = "/";

//    AUTH CONTROLLER
    public static final String AUTH = INDEX + "auth/";
    public static final String LOCATION = INDEX + "location/";
    public static final String TOTALRATINGREST = INDEX + "totalratingrest/";
    public static final String STAFFRATING = INDEX + "staffrating/";
    public static final String JANUARYREST = INDEX + "januaryrest/";
    public static final String HIGHESTPRICE= INDEX + "highestprice/";
    public static final String MANAGERCATEGORY = INDEX + "managercategory/";
    public static final String CATEGORIES = INDEX + "categories";
    public static final String AVERAGETYPECAT = INDEX + "averagetypecat/";
    public static final String TYPEHIGHESTFOOD = INDEX + "typehighestfood/";
    public static final String LOGIN = AUTH + "login/";
    public static final String SIGNUP = AUTH + "signup/";
    public static final String MENUITEMRATING = INDEX + "menuitemid";

//    RESTAURANT CONTROLLER
    public static final String RESTAU = INDEX + "restau/";


    //ratings controller
    public static final String RATE = "rate/";
    public static final String UPVOTE =  "upvote-rater/";
    public static final String DOWNVOTE =  "downvote-rater/";

    //MenuItem Controller
    public static final String GETMENU = INDEX + "getmenu/";

    //RATER CONTROLLER
    public static final String HIGHEST_FOOD_AND_MOOD = INDEX+"hfam/";
    public static final String HIGHEST_FOOD_OR_MOOD =INDEX+ "hfom/";
    public static final String FREQUENT_RATERS = "freq-raters/";
    public static final String LOWER_THAN_X = INDEX+"lower-than/";
    public static final String POLARIZING_RATINGS = INDEX+"polarizing/";
    public static final String GET_ALL_RATERS = INDEX + "raternames/";
    public static final String DELETE_CURRENT_USER = INDEX + "deleteuser/";

    //RATING ITEM CONTROLLER
    public static final String RATEITEM = INDEX+"rateitem/";
}
