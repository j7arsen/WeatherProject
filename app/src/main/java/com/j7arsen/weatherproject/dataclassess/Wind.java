package com.j7arsen.weatherproject.dataclassess;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by j7ars on 11.07.2017.
 */

public class Wind implements Parcelable {

    @SerializedName("speed")
    private double mSpeed;
    @SerializedName("deg")
    private double mDeg;

    public double getSpeed() {
        return mSpeed;
    }

    public void setSpeed(double mSpeed) {
        this.mSpeed = mSpeed;
    }

    public double getDeg() {
        return mDeg;
    }

    public void setDeg(double mDeg) {
        this.mDeg = mDeg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.mSpeed);
        dest.writeDouble(this.mDeg);
    }

    public Wind() {
    }

    protected Wind(Parcel in) {
        this.mSpeed = in.readInt();
        this.mDeg = in.readInt();
    }

    public static final Parcelable.Creator<Wind> CREATOR = new Parcelable.Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel source) {
            return new Wind(source);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };
}
