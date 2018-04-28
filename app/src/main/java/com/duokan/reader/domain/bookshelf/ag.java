package com.duokan.reader.domain.bookshelf;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ag implements Creator<BookTag> {
    ag() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3787a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3788a(i);
    }

    /* renamed from: a */
    public BookTag m3787a(Parcel parcel) {
        return new BookTag(parcel);
    }

    /* renamed from: a */
    public BookTag[] m3788a(int i) {
        return new BookTag[i];
    }
}
