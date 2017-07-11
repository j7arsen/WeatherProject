package com.j7arsen.weatherproject.api.service;

import com.j7arsen.weatherproject.api.Urls;
import com.j7arsen.weatherproject.api.response.WeatherResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by j7ars on 11.07.2017.
 */
public interface GetWeatherService {

    @GET(Urls.BASE_URL)
    Single<WeatherResponse> getWeatherData(@QueryMap Map<String, String> params);

}
