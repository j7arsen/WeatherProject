package com.j7arsen.weatherproject.base;

/**
 * Created by j7ars on 11.07.2017.
 */

public interface IPresenter<V extends IMvpView> {

    void attachView(V mvpView);

    void detachView();

}
