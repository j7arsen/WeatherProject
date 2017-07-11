package com.j7arsen.weatherproject.di.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import com.j7arsen.weatherproject.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 11.07.2017.
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    Fragment providesFragment() {
        return mFragment;
    }

    @Provides
    Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mFragment.getActivity();
    }

}
