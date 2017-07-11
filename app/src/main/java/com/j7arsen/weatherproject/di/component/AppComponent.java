package com.j7arsen.weatherproject.di.component;

import android.app.Application;
import android.content.Context;

import com.j7arsen.weatherproject.api.RequestManager;
import com.j7arsen.weatherproject.di.module.AppModule;
import com.j7arsen.weatherproject.di.module.NetModule;
import com.j7arsen.weatherproject.di.qualifier.AppContext;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by j7ars on 11.07.2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    @AppContext
    Context context();
    Application application();
    Retrofit provideRetrofit();
    RequestManager provideRequestManager();

}
