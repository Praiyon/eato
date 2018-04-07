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
    public static final String LOGOUT = AUTH + "logout/";
    public static final String SIGNUP = AUTH + "signup/";

    //    BROWSE CONTROLLER
    public static final String BROWSE = INDEX +"browse/";

//    RESTAURANT CONTROLLER
    public static final String RESTAU = INDEX + "restau/";
    public static final String MENU = RESTAU+ "menu/";


    public static final String RATE = "rate/";
}
