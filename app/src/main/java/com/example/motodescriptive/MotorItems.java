package com.example.motodescriptive;

import android.os.Parcel;
import android.os.Parcelable;

public class MotorItems implements Parcelable {
    private String name;
    private String description;
    private String imageURL;
    private String fullDescription;

    public MotorItems(String name, String description, String fullDescription, String imageURL) {
        this.name = name;
        this.description = description;
        this.fullDescription = fullDescription;
        this.imageURL = imageURL;
    }

    protected MotorItems(Parcel in) {
        name = in.readString();
        description = in.readString();
        fullDescription = in.readString();
        imageURL = in.readString();
    }

    public static final Creator<MotorItems> CREATOR = new Creator<MotorItems>() {
        @Override
        public MotorItems createFromParcel(Parcel in) {
            return new MotorItems(in);
        }

        @Override
        public MotorItems[] newArray(int size) {
            return new MotorItems[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(fullDescription);
        parcel.writeString(imageURL);
    }
}
