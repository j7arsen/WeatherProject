package com.j7arsen.weatherproject.utils;

import com.j7arsen.weatherproject.app.WeatherApp;

/**
 * Created by j7ars on 11.07.2017.
 */

public class FieldConverter {

    public static String getString(int resId) {
        return WeatherApp.mInstance.getResources().getString(resId);
    }

}
