package com.j7arsen.weatherproject.utils;

import java.util.regex.Pattern;

/**
 * Created by j7ars on 11.07.2017.
 */

public class ValidFields {

    private static final Pattern emailPattern
            = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");

    private static final Pattern passwordPattern
            = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20})");

    public static boolean isEmailValid(String email){
        if(emailPattern.matcher(email).matches()){
            return true;
        }
        return false;
    }

    public static boolean isPasswordValid(String password){
        if(passwordPattern.matcher(password).matches()){
            return true;
        }
        return false;
    }


}
