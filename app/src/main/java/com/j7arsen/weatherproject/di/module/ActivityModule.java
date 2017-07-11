package com.j7arsen.weatherproject.di.module;

import android.app.Activity;
import android.content.Context;

import com.j7arsen.weatherproject.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 11.07.2017.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }

}
