package com.j7arsen.weatherproject.dataclassess;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by j7ars on 11.07.2017.
 */

public class Weather implements Parcelable {

    @SerializedName("id")
    private int mId;
    @SerializedName("main")
    private String mMain;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("icon")
    private String mIcon;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String mMain) {
        this.mMain = mMain;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mMain);
        dest.writeString(this.mDescription);
        dest.writeString(this.mIcon);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.mId = in.readInt();
        this.mMain = in.readString();
        this.mDescription = in.readString();
        this.mIcon = in.readString();
    }

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
