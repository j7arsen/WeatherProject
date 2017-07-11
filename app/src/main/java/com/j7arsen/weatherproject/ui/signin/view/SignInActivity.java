package com.j7arsen.weatherproject.ui.signin.view;

import android.os.Bundle;

import com.j7arsen.weatherproject.R;
import com.j7arsen.weatherproject.base.BaseBackContainerActivity;
import com.j7arsen.weatherproject.utils.FieldConverter;

/**
 * Created by j7ars on 11.07.2017.
 */

public class SignInActivity extends BaseBackContainerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(FieldConverter.getString(R.string.auth_button_name));
        if (savedInstanceState == null) {
            openFragment();
        }
    }

    @Override
    protected void openFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, SignInFragment.newInstance()).commit();
    }
}
