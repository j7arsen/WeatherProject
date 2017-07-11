package com.j7arsen.weatherproject.di.component;

import com.j7arsen.weatherproject.di.module.FragmentModule;
import com.j7arsen.weatherproject.di.scope.PerActivity;
import com.j7arsen.weatherproject.ui.signin.view.SignInFragment;

import dagger.Subcomponent;

/**
 * Created by j7ars on 11.07.2017.
 */
@PerActivity
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(SignInFragment signInFragment);

}
