package com.j7arsen.weatherproject.ui.signin.presenter;

import com.j7arsen.weatherproject.api.RequestManager;
import com.j7arsen.weatherproject.api.RequestParams;
import com.j7arsen.weatherproject.api.response.WeatherResponse;
import com.j7arsen.weatherproject.app.Constants;
import com.j7arsen.weatherproject.base.BasePresenter;
import com.j7arsen.weatherproject.dataclassess.WeatherData;
import com.j7arsen.weatherproject.progress.ErrorHandler;
import com.j7arsen.weatherproject.ui.signin.ISignInContract;
import com.j7arsen.weatherproject.utils.ValidFields;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by j7ars on 11.07.2017.
 */

public class SignInPresenter extends BasePresenter<ISignInContract.View> implements ISignInContract.Presenter {

    private Disposable mDisposable;

    @Inject
    RequestManager mRequestManager;

    @Inject
    public SignInPresenter(){
        mDisposable = Disposables.empty();
    }

    @Override
    public void attachView(ISignInContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void getWeatherData(String email, String password) {
        checkEmail(email);
        checkPassword(password);
        if(checkEmail(email) && checkPassword(password)){
            mDisposable = mRequestManager.getWeatherData(RequestParams.getWeatherParams())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(@NonNull Disposable disposable) throws Exception {
                            getMvpView().startProgressDialog();
                        }
                    })
                    .doOnSuccess(new Consumer<WeatherResponse>() {
                        @Override
                        public void accept(@NonNull WeatherResponse weatherResponse) throws Exception {
                            undisposable(mDisposable);
                            getMvpView().completeProgressDialog();
                            if(weatherResponse.getWeatherDataList() != null && weatherResponse.getWeatherDataList().size() != 0) {
                                for(WeatherData weatherData : weatherResponse.getWeatherDataList()){
                                    if(weatherData.getSys() != null){
                                        if(weatherData.getSys().getCountry().equalsIgnoreCase(Constants.LANG)){
                                            getMvpView().showWeatherData("Temparature in " + weatherData.getName() + " = " + weatherData.getMain().getTemp());
                                        }
                                    }
                                }

                            }
                            //TODO show result
                        }
                    })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(@NonNull Throwable throwable) throws Exception {
                            undisposable(mDisposable);
                            getMvpView().errorProgressDialog(new ErrorHandler(throwable));
                        }
                    })
                    .subscribe();
            addDisposable(mDisposable);
        }
    }

    private boolean checkEmail(String email){
        if(ValidFields.isEmailValid(email)){
            getMvpView().setError(true, false);
            return true;
        } else{
            getMvpView().setError(true, true);
            return false;
        }
    }

    private boolean checkPassword(String password){
        if(ValidFields.isPasswordValid(password)){
            getMvpView().setError(false, false);
            return true;
        } else{
            getMvpView().setError(false, true);
            return false;
        }
    }

    @Override
    public void detachView() {
        super.detachView();
    }
}
