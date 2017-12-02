package com.duokan.reader.domain.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

import com.duokan.b.i;

public class BookTag implements Parcelable {
    public static final Creator CREATOR = new ag();
    public static final String a = BookTag.class.getName();
    public static final int b = i.booktag__shared__unarrangement;
    public static final int c = i.booktag__shared__my_download;
    private long d;
    private long e;
    private String f;
    private BookTagType g;

    public enum BookTagType {
        PREDEFINED,
        CUSTOM
    }

    public long a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) 1);
        parcel.writeLong(this.d);
        parcel.writeByte((byte) 2);
        parcel.writeLong(this.e);
        parcel.writeByte((byte) 3);
        parcel.writeString(this.f);
        parcel.writeByte((byte) 4);
        parcel.writeString(this.g.toString());
        parcel.writeByte((byte) 5);
    }

    private BookTag(Parcel parcel) {
        while (parcel.dataAvail() > 0) {
            byte readByte = parcel.readByte();
            if (readByte != (byte) 5) {
                switch (readByte) {
                    case (byte) 1:
                        this.d = parcel.readLong();
                        break;
                    case (byte) 2:
                        this.e = parcel.readLong();
                        break;
                    case (byte) 3:
                        this.f = parcel.readString();
                        break;
                    case (byte) 4:
                        this.g = BookTagType.valueOf(parcel.readString());
                        break;
                    default:
                        Log.d(a, "unrecognized block : " + readByte);
                        break;
                }
            }
            return;
        }
    }
}
