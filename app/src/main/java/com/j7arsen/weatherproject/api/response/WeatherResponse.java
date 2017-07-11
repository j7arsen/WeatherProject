package com.j7arsen.weatherproject.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.j7arsen.weatherproject.dataclassess.WeatherData;

import java.util.List;

/**
 * Created by j7ars on 11.07.2017.
 */

public class WeatherResponse implements Parcelable {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("cod")
    private String mCode;
    @SerializedName("count")
    private int mCount;
    @SerializedName("list")
    private List<WeatherData> mWeatherDataList;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    public List<WeatherData> getWeatherDataList() {
        return mWeatherDataList;
    }

    public void setWeatherDataList(List<WeatherData> mWeatherDataList) {
        this.mWeatherDataList = mWeatherDataList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mMessage);
        dest.writeString(this.mCode);
        dest.writeInt(this.mCount);
        dest.writeTypedList(this.mWeatherDataList);
    }

    public WeatherResponse() {
    }

    protected WeatherResponse(Parcel in) {
        this.mMessage = in.readString();
        this.mCode = in.readString();
        this.mCount = in.readInt();
        this.mWeatherDataList = in.createTypedArrayList(WeatherData.CREATOR);
    }

    public static final Parcelable.Creator<WeatherResponse> CREATOR = new Parcelable.Creator<WeatherResponse>() {
        @Override
        public WeatherResponse createFromParcel(Parcel source) {
            return new WeatherResponse(source);
        }

        @Override
        public WeatherResponse[] newArray(int size) {
            return new WeatherResponse[size];
        }
    };
}
