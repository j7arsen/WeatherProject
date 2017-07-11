package com.j7arsen.weatherproject.api;

import com.j7arsen.weatherproject.app.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by j7ars on 11.07.2017.
 */

public class RequestParams {

    public static Map<String, String> getWeatherParams(){
        HashMap<String, String> params = new HashMap<>();
        params.put(RequestField.QUERY, Constants.LOCATION);
        params.put(RequestField.LANG, Constants.LANG);
        params.put(RequestField.TYPE, Constants.TYPE_LIKE);
        params.put(RequestField.UNITS, Constants.UNITS_METRIC);
        params.put(RequestField.APPID, Constants.API_TOKEN);
        return params;
    }

}
