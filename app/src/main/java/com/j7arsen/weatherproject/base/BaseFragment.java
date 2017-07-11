package com.j7arsen.weatherproject.base;

import android.app.Fragment;
import android.os.Bundle;

import com.j7arsen.weatherproject.app.WeatherApp;
import com.j7arsen.weatherproject.di.component.ConfigPersistentComponent;
import com.j7arsen.weatherproject.di.component.DaggerConfigPersistentComponent;
import com.j7arsen.weatherproject.di.component.FragmentComponent;
import com.j7arsen.weatherproject.di.module.FragmentModule;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by j7ars on 11.07.2017.
 */

public abstract class BaseFragment extends Fragment {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final Map<Long, ConfigPersistentComponent> sComponentsMap = new HashMap<>();

    private FragmentComponent mFragmentComponent;
    private long mActivityId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (!sComponentsMap.containsKey(mActivityId)) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .appComponent(WeatherApp.get(getActivity()).getComponent())
                    .build();
            sComponentsMap.put(mActivityId, configPersistentComponent);
        } else {
            configPersistentComponent = sComponentsMap.get(mActivityId);
        }
        mFragmentComponent = configPersistentComponent.fragmentComponent(new FragmentModule(this));
        setupComponent();
    }

    protected abstract void setupComponent();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, mActivityId);
    }

    @Override
    public void onDestroy() {
        if (!getActivity().isChangingConfigurations()) {
            sComponentsMap.remove(mActivityId);
        }
        super.onDestroy();
    }

    public FragmentComponent fragmentComponent() {
        return mFragmentComponent;
    }

}
