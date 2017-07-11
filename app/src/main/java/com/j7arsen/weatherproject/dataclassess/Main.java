package com.j7arsen.weatherproject.dataclassess;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by j7ars on 11.07.2017.
 */

public class Main implements Parcelable {

    @SerializedName("temp")
    private double mTemp;
    @SerializedName("pressure")
    private int mPressure;
    @SerializedName("humidity")
    private int mHumidity;
    @SerializedName("temp_min")
    private int mTempMin;
    @SerializedName("temp_max")
    private int mTempMax;

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double mTemp) {
        this.mTemp = mTemp;
    }

    public int getPressure() {
        return mPressure;
    }

    public void setPressure(int mPressure) {
        this.mPressure = mPressure;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int mHumidity) {
        this.mHumidity = mHumidity;
    }

    public int getTempMin() {
        return mTempMin;
    }

    public void setTempMin(int mTempMin) {
        this.mTempMin = mTempMin;
    }

    public int getTempMax() {
        return mTempMax;
    }

    public void setTempMax(int mTempMax) {
        this.mTempMax = mTempMax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.mTemp);
        dest.writeInt(this.mPressure);
        dest.writeInt(this.mHumidity);
        dest.writeInt(this.mTempMin);
        dest.writeInt(this.mTempMax);
    }

    public Main() {
    }

    protected Main(Parcel in) {
        this.mTemp = in.readDouble();
        this.mPressure = in.readInt();
        this.mHumidity = in.readInt();
        this.mTempMin = in.readInt();
        this.mTempMax = in.readInt();
    }

    public static final Parcelable.Creator<Main> CREATOR = new Parcelable.Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel source) {
            return new Main(source);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}
