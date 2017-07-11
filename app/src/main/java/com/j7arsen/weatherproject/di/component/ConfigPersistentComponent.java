package com.j7arsen.weatherproject.di.component;

import com.j7arsen.weatherproject.di.module.ActivityModule;
import com.j7arsen.weatherproject.di.module.FragmentModule;
import com.j7arsen.weatherproject.di.scope.ConfigPersistent;

import dagger.Component;

/**
 * Created by j7ars on 11.07.2017.
 */
@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

}
