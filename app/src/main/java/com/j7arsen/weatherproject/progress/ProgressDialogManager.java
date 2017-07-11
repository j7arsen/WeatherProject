package com.j7arsen.weatherproject.progress;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by j7ars on 11.07.2017.
 */

public class ProgressDialogManager implements ProgressDialog.OnProgressDialogVisibleListener{
    private static ProgressDialogManager ourInstance = new ProgressDialogManager();

    private ProgressDialog mProgressDialog;

    private ProgressEvent mProgressEvent;

    private ProgressDialogManager() {
    }

    public static ProgressDialogManager getInstance() {
        return ourInstance;
    }

    private void subscribe() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog();
            mProgressDialog.setOnProgressDialogVisibleListener(this);
        }
    }

    public void unsubscribe() {
        if (mProgressDialog != null && mProgressDialog.isAdded()) {
            mProgressDialog.dismissAllowingStateLoss();
            mProgressDialog = null;
        }
    }

    public void startLoading(Activity activity) {
        subscribe();
        if (!mProgressDialog.isVisible() && !mProgressDialog.isAdded()) {
            mProgressDialog.show(activity.getFragmentManager(), ProgressDialog.TAG);
        }
        mProgressEvent = new ProgressEvent(ProgressEvent.START_PROGRESS);
        mProgressDialog.startLoading();
    }

    public void startLoading(Fragment fragment) {
        subscribe();
        mProgressDialog.show(fragment.getFragmentManager(), ProgressDialog.TAG);
        mProgressEvent = new ProgressEvent(ProgressEvent.START_PROGRESS);
        mProgressDialog.startLoading();
    }

    public void errorLoading(ErrorHandler errorHandler) {
        if(mProgressDialog != null && mProgressDialog.isAdded()) {
            mProgressDialog.errorLoading(errorHandler);
        } else{
            mProgressEvent = new ProgressEvent(ProgressEvent.ERROR_PROGRESS, errorHandler);
        }
    }

    public void completeLoading() {
        if(mProgressDialog != null && mProgressDialog.isAdded()) {
            mProgressDialog.completeLoading();
            unsubscribe();
        } else{
            mProgressEvent = new ProgressEvent(ProgressEvent.COMPLETE_PROGRESS);
        }
    }

    @Override
    public void onProgressDialogVisible() {
        switch (mProgressEvent.getStatus()){
            case ProgressEvent.COMPLETE_PROGRESS:
                completeLoading();
                break;
            case ProgressEvent.ERROR_PROGRESS:
                errorLoading(mProgressEvent.getErrorHandler());
                break;
        }
    }
}
