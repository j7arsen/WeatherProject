package com.j7arsen.weatherproject.api;

import com.j7arsen.weatherproject.api.response.WeatherResponse;
import com.j7arsen.weatherproject.api.service.GetWeatherService;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by j7ars on 11.07.2017.
 */

public class RequestManager {

    private static RequestManager mInstance;

    private Retrofit mRetrofit;

    public static RequestManager getInstance(Retrofit retrofit) {
        if (mInstance == null) {
            mInstance = new RequestManager(retrofit);
        }
        return mInstance;
    }

    private RequestManager(Retrofit retrofit){
        this.mRetrofit = retrofit;
    }

    private <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public Single<WeatherResponse> getWeatherData(Map<String, String> params){
        return createService(GetWeatherService.class).getWeatherData(params);
    }

}
