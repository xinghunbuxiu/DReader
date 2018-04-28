package com.duokan.reader.domain.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.duokan.p023b.C0247i;

public class BookTag implements Parcelable {
    public static final Creator<BookTag> CREATOR = new ag();
    /* renamed from: a */
    public static final String f2671a = BookTag.class.getName();
    /* renamed from: b */
    public static final int f2672b = C0247i.booktag__shared__unarrangement;
    /* renamed from: c */
    public static final int f2673c = C0247i.booktag__shared__my_download;
    /* renamed from: d */
    private long f2674d;
    /* renamed from: e */
    private long f2675e;
    /* renamed from: f */
    private String f2676f;
    /* renamed from: g */
    private BookTagType f2677g;

    public enum BookTagType {
        PREDEFINED,
        CUSTOM
    }

    /* renamed from: a */
    public long m3708a() {
        return this.f2674d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) 1);
        parcel.writeLong(this.f2674d);
        parcel.writeByte((byte) 2);
        parcel.writeLong(this.f2675e);
        parcel.writeByte((byte) 3);
        parcel.writeString(this.f2676f);
        parcel.writeByte((byte) 4);
        parcel.writeString(this.f2677g.toString());
        parcel.writeByte((byte) 5);
    }

    private BookTag(Parcel parcel) {
        while (parcel.dataAvail() > 0) {
            byte readByte = parcel.readByte();
            if (readByte != (byte) 5) {
                switch (readByte) {
                    case (byte) 1:
                        this.f2674d = parcel.readLong();
                        break;
                    case (byte) 2:
                        this.f2675e = parcel.readLong();
                        break;
                    case (byte) 3:
                        this.f2676f = parcel.readString();
                        break;
                    case (byte) 4:
                        this.f2677g = BookTagType.valueOf(parcel.readString());
                        break;
                    default:
                        Log.d(f2671a, "unrecognized block : " + readByte);
                        break;
                }
            }
            return;
        }
    }
}
