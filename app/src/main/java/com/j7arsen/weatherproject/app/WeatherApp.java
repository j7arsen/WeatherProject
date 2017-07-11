package com.j7arsen.weatherproject.app;

import android.app.Application;
import android.content.Context;

import com.j7arsen.weatherproject.di.component.AppComponent;
import com.j7arsen.weatherproject.di.component.DaggerAppComponent;
import com.j7arsen.weatherproject.di.module.AppModule;

/**
 * Created by j7ars on 11.07.2017.
 */

public class WeatherApp extends Application {

    AppComponent mApplicationComponent;

    public static WeatherApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static WeatherApp get(Context context) {
        return (WeatherApp) context.getApplicationContext();
    }

    public AppComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public void setComponent(AppComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
