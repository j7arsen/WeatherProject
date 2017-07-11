package com.j7arsen.weatherproject.base;

import android.os.Bundle;
import android.view.View;

import com.j7arsen.weatherproject.utils.UI;

/**
 * Created by j7ars on 11.07.2017.
 */

public abstract class BaseBackContainerActivity extends BaseContainerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        UI.animationCloseActivity(this);
    }

}
