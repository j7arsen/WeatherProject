package com.j7arsen.weatherproject.progress;

/**
 * Created by j7ars on 11.07.2017.
 */

public class ProgressEvent {

    public static final int START_PROGRESS = 0;
    public static final int COMPLETE_PROGRESS = 1;
    public static final int ERROR_PROGRESS = 2;

    private int mStatus;
    private ErrorHandler mErrorHandler;

    public ProgressEvent(int mStatus) {
        this.mStatus = mStatus;
    }

    public ProgressEvent(int mStatus, ErrorHandler mErrorHandler) {
        this.mStatus = mStatus;
        this.mErrorHandler = mErrorHandler;
    }

    public ErrorHandler getErrorHandler() {
        return mErrorHandler;
    }

    public void setErrorHandler(ErrorHandler mErrorHandler) {
        this.mErrorHandler = mErrorHandler;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

}
