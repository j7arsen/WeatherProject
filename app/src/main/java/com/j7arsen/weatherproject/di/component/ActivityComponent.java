package com.j7arsen.weatherproject.di.component;

import com.j7arsen.weatherproject.di.module.ActivityModule;
import com.j7arsen.weatherproject.di.scope.PerActivity;

import dagger.Subcomponent;

/**
 * Created by j7ars on 11.07.2017.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

}
