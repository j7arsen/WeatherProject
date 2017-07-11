package com.j7arsen.weatherproject.dataclassess;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j7ars on 11.07.2017.
 */

public class WeatherData implements Parcelable {

    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("dt")
    private long mDt;
    @SerializedName("rain")
    private boolean isRain;
    @SerializedName("snow")
    private boolean isSnow;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("wind")
    private Wind mWind;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("weather")
    private List<Weather> mWeathers;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public long getDt() {
        return mDt;
    }

    public void setDt(long mDt) {
        this.mDt = mDt;
    }

    public boolean isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = rain;
    }

    public boolean isSnow() {
        return isSnow;
    }

    public void setSnow(boolean snow) {
        isSnow = snow;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord mCoord) {
        this.mCoord = mCoord;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main mMain) {
        this.mMain = mMain;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind mWind) {
        this.mWind = mWind;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys mSys) {
        this.mSys = mSys;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds mClouds) {
        this.mClouds = mClouds;
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public void setWeathers(List<Weather> mWeathers) {
        this.mWeathers = mWeathers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mName);
        dest.writeLong(this.mDt);
        dest.writeByte(this.isRain ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSnow ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.mCoord, flags);
        dest.writeParcelable(this.mMain, flags);
        dest.writeParcelable(this.mWind, flags);
        dest.writeParcelable(this.mSys, flags);
        dest.writeParcelable(this.mClouds, flags);
        dest.writeTypedList(this.mWeathers);
    }

    public WeatherData() {
    }

    protected WeatherData(Parcel in) {
        this.mId = in.readInt();
        this.mName = in.readString();
        this.mDt = in.readLong();
        this.isRain = in.readByte() != 0;
        this.isSnow = in.readByte() != 0;
        this.mCoord = in.readParcelable(Coord.class.getClassLoader());
        this.mMain = in.readParcelable(Main.class.getClassLoader());
        this.mWind = in.readParcelable(Wind.class.getClassLoader());
        this.mSys = in.readParcelable(Sys.class.getClassLoader());
        this.mClouds = in.readParcelable(Clouds.class.getClassLoader());
        this.mWeathers = in.createTypedArrayList(Weather.CREATOR);
    }

    public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel source) {
            return new WeatherData(source);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };
}
