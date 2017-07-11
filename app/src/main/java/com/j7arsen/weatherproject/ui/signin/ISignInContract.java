package com.j7arsen.weatherproject.ui.signin;

import com.j7arsen.weatherproject.base.IMvpView;
import com.j7arsen.weatherproject.base.IPresenter;
import com.j7arsen.weatherproject.dataclassess.ValidationErrorType;
import com.j7arsen.weatherproject.progress.ErrorHandler;

/**
 * Created by j7ars on 11.07.2017.
 */

public interface ISignInContract {

    interface View extends IMvpView {
        void startProgressDialog();
        void completeProgressDialog();
        void errorProgressDialog(ErrorHandler errorHandler);
        void setError(ValidationErrorType validationErrorType, boolean isError);
        void showWeatherData(String weatherData);
    }

    interface Presenter extends IPresenter<View> {
        void getWeatherData(String email, String password);
    }

}
