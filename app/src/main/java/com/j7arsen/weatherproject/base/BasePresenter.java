package com.j7arsen.weatherproject.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by j7ars on 11.07.2017.
 */

public class BasePresenter<T extends IMvpView> implements IPresenter<T> {

    //list of disposable
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        checkViewAttached();
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }


    public void addDisposable(Disposable disposable){
        mCompositeDisposable.add(disposable);
    }

    public void undisposable(Disposable disposable){
        if(mCompositeDisposable.size() != 0){
            if(!disposable.isDisposed()) {
                mCompositeDisposable.remove(disposable);
            }
        }
    }

    public void undisposableAll(){
        if(!mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

}
