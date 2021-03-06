package com.smadmin.multiscreenapp.items.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StubItem implements Parcelable {

    private final String id;
    private final String content;
    private final String details;
    private boolean favoriteStatus;

    StubItem(String id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.content);
        dest.writeString(this.details);
    }

    public StubItem(Parcel in) {
        this.id = in.readString();
        this.content = in.readString();
        this.details = in.readString();
    }

    public static final Parcelable.Creator<StubItem> CREATOR = new Parcelable.Creator<StubItem>() {
        @Override
        public StubItem createFromParcel(Parcel source) {
            return new StubItem(source);
        }

        @Override
        public StubItem[] newArray(int size) {
            return new StubItem[size];
        }
    };

    public void setFavoriteStatus(boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public boolean isFavoriteStatus() {
        return favoriteStatus;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "StubItem{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
