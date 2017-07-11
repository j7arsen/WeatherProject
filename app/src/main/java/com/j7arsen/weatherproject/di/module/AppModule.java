package com.j7arsen.weatherproject.di.module;

import android.app.Application;
import android.content.Context;

import com.j7arsen.weatherproject.api.RequestManager;
import com.j7arsen.weatherproject.di.qualifier.AppContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by j7ars on 11.07.2017.
 */
@Module
public class AppModule {

    protected final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @AppContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    RequestManager provideRequestManager(Retrofit retrofit){
        return RequestManager.getInstance(retrofit);
    }

}
