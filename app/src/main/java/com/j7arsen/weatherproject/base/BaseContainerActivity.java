package com.j7arsen.weatherproject.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.j7arsen.weatherproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by j7ars on 11.07.2017.
 */

public abstract class BaseContainerActivity extends BaseActivity {

    @BindView(R.id.navigation_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    protected abstract void openFragment();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
