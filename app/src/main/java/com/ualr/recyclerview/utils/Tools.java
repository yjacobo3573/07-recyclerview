package com.ualr.recyclerview.utils;

/**
 * Created by irconde on 2019-09-25.
 */
public class Tools {

    public static String getEmailFromName(String name) {
        if (name != null && !name.equals("")) {
            String email = name.replaceAll(" ", ".").toLowerCase().concat("@mail.com");
            return email;
        }
        return name;
    }
}
