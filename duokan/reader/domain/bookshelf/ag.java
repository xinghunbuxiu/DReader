package com.duokan.reader.domain.bookshelf;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ag implements Creator {
    ag() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public BookTag a(Parcel parcel) {
        return new BookTag(parcel);
    }

    public BookTag[] a(int i) {
        return new BookTag[i];
    }
}
