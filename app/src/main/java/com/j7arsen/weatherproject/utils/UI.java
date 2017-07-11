package com.j7arsen.weatherproject.utils;

import android.app.Activity;
import android.view.animation.Animation;

import com.j7arsen.weatherproject.R;

/**
 * Created by j7ars on 11.07.2017.
 */

public class UI {

    public static void animationOpenActivity(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    public static void animationCloseActivity(Activity activity) {
        activity.overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }

}
